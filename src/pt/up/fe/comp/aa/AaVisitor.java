package pt.up.fe.comp.aa;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Pair;
import pt.up.fe.comp.aa.parser.aaBaseVisitor;
import pt.up.fe.comp.aa.parser.aaParser;
import pt.up.fe.comp.fsa.FSA;
import pt.up.fe.comp.fsa.FSALoader;
import pt.up.fe.comp.fsa.Operations;
import pt.up.fe.comp.utils.Producer;
import pt.up.fe.comp.utils.SymbolTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AaVisitor extends aaBaseVisitor<Object> {

    private class AaArgumentVisitor extends aaBaseVisitor<Object> {
        @Override
        public Object visitArg(@NotNull aaParser.ArgContext ctx) {
            if (ctx.IDENTIFIER() != null) {
                return _symbols.get(ctx.IDENTIFIER().toString());
            } else if (ctx.STRING() != null) {
                String str = ctx.STRING().getText();
                str = str.substring(1, str.length() - 1);
                return str;
            } else if (ctx.operation() != null) {
                return AaVisitor.this.visit(ctx.operation());
            }

            return null;
        }
    }

    private AaArgumentVisitor _argVisitor = new AaArgumentVisitor();

    private SymbolTable<Object> _symbols = new SymbolTable<>();

    @Override
    public Object visitStmt_list(@NotNull aaParser.Stmt_listContext ctx) {
        _symbols.beginScope();
        Object result = null;
        for (aaParser.StmtContext stmt : ctx.stmt())
            result = visit(stmt);
        _symbols.endScope();
        return result;
    }

    @Override
    public Object visitStmt(@NotNull aaParser.StmtContext ctx) {
        assert (ctx.getChildCount() == 1);
        return visitChildren(ctx);
    }

    private Class getArgType(@NotNull aaParser.ArgContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return _symbols.getType(ctx.IDENTIFIER().toString());
        } else if (ctx.STRING() != null) {
            return String.class;
        } else if (ctx.operation() != null) {
            return metaVisitOperation(ctx.operation()).a;
        }

        return null;
    }

    private Pair<Class, Producer<Object>> metaVisitOperation(@NotNull final aaParser.OperationContext ctx) {
        String operation = ctx.operator.getText();
        Class operations = Operations.class;
        List<Method> methods = Arrays.asList(operations.getMethods());
        Method op = null;
        for (Method m : methods) {
            if (m.getName().equals(operation)) {
                op = m;
                break;
            }
        }

        if (op == null)
            throw new Error("No such operator: " + operation);

        Class[] paramTypes = op.getParameterTypes();
        aaParser.Arg_listContext argumentListContext = ctx.arg_list();
        List<aaParser.ArgContext> args = argumentListContext.arg();


        if (args.size() != paramTypes.length && !paramTypes[paramTypes.length - 1].isArray()) {
            throw new Error("No operator '" + operation + "' with " + Integer.toString(args.size()));
        }
        {
            int i = 0, j = 0;
            for (; i < paramTypes.length && j < args.size(); ++i, ++j) {
                Class paramT = getArgType(args.get(j));
                if (paramTypes[i].isArray()) {
                    Class paramType = paramTypes[i].getComponentType();
                    while (j < args.size() && paramType.equals(paramT)) {
                        ++j;
                        if (j == args.size()) break;
                        paramT = getArgType(args.get(j));
                    }
                } else if (!paramTypes[i].equals(paramT))
                    throw new Error("No operator '" + operation + "' with argument " + Integer.toString(i) + " of type " + paramT.getSimpleName());
            }

            if (i < (paramTypes.length - (paramTypes[paramTypes.length - 1].isArray() ? 1 : 0)) || j < args.size())
                throw new Error("No operator '" + operation + "' with " + Integer.toString(args.size()) + " parameters defined.");

            Class returnType = op.getReturnType();
            return new Pair<Class, Producer<Object>>(returnType, new Producer<Object>() {
                @Override
                public Object produce() {
                    return visit(ctx);
                }
            });
        }
    }

    @Override
    public Object visitAttribution(@NotNull aaParser.AttributionContext ctx) {
        String name = ctx.attribution_lhs().IDENTIFIER().getText();
        aaParser.Attribution_rhsContext rhs = ctx.attribution_rhs();

        if (rhs.operation() != null) {
            Pair<Class, Producer<Object>> classProducerPair = metaVisitOperation(rhs.operation());
            _symbols.addSymbol(name, classProducerPair.a, classProducerPair.b);
        } else if (rhs.IDENTIFIER() != null) {
            final String id = rhs.IDENTIFIER().getText();

            if (!_symbols.contains(id))
                throw new Error("Identifier " + id + " is not declared in the current scope.");
            _symbols.addSymbol(name, _symbols.getType(rhs.IDENTIFIER().getText()), new Producer<Object>() {
                @Override
                public Object produce() {
                    return _symbols.get(id);
                }
            });

        } else if (rhs.STRING() != null) {
            String fileName = rhs.STRING().getText();
            fileName = fileName.substring(1, fileName.length() - 1);
            File f = new File(fileName);
            if (!f.exists())
                throw new Error(new FileNotFoundException(f.getAbsolutePath()));

            final String finalFileName = fileName;
            _symbols.addSymbol(name, FSA.class, new Producer<Object>() {
                @Override
                public Object produce() {
                    try {
                        return FSALoader.LoadFromFile(finalFileName);
                    } catch (IOException e) {
                        throw new Error(e.getMessage());
                    }
                }
            });

            return null;
        }

        return null;
    }

    @Override
    public Object visitControl_expr(@NotNull aaParser.Control_exprContext ctx) {
        Object predEval = visit(ctx.predicate);
        if (!(predEval instanceof Boolean))
            throw new Error("Invalid Predicate");

        if ((Boolean) predEval) {
            return visit(ctx.trueCase);
        } else if (ctx.falseCase != null) {
            return visit(ctx.falseCase);
        }
        return null;
    }

    @Override
    public Object visitOperation(@NotNull aaParser.OperationContext ctx) {
        String operation = ctx.operator.getText();
        Class operations = Operations.class;
        List<Method> methods = Arrays.asList(operations.getMethods());
        Method op = null;
        for (Method m : methods) {
            if (m.getName().equals(operation)) {
                op = m;
                break;
            }
        }

        if (op == null)
            throw new Error("No such operator: " + operation);

        Class[] paramTypes = op.getParameterTypes();
        List<Object> params = new ArrayList<>();
        aaParser.Arg_listContext argumentListContext = ctx.arg_list();
        List<aaParser.ArgContext> args = argumentListContext.arg();


        if (args.size() != paramTypes.length && !paramTypes[paramTypes.length - 1].isArray()) {
            throw new Error("No operator '" + operation + "' with " + Integer.toString(paramTypes.length));
        }
        {
            int i = 0, j = 0;
            for (; i < paramTypes.length && j < args.size(); ++i, ++j) {
                Object param = _argVisitor.visit(args.get(j));
                if (paramTypes[i].isArray()) {
                    Class paramType = paramTypes[i].getComponentType();
                    List<Object> array = new ArrayList<>();
                    while (param != null && j < args.size() && paramType.isInstance(param)) {
                        array.add(param);
                        ++j;
                        if (j == args.size()) break;
                        param = _argVisitor.visit(args.get(j));
                    }
                    param = array.toArray((Object[]) Array.newInstance(paramType, array.size()));
                } else if (!paramTypes[i].isInstance(param))
                    throw new Error("No operator '" + operation + "' with argument " + Integer.toString(i) + " of type " + param.getClass().getSimpleName());

                params.add(param);
            }

            if (paramTypes[paramTypes.length - 1].isArray() && params.size() == (paramTypes.length - 1))
                params.add(Array.newInstance(paramTypes[paramTypes.length - 1].getComponentType(), 0));

            if (i < (paramTypes.length - (paramTypes[paramTypes.length - 1].isArray() ? 1 : 0)) || j < args.size())
                throw new Error("No operator '" + operation + "' with " + Integer.toString(args.size()) + " parameters defined.");
        }

        try {
            return op.invoke(null, params.toArray(new Object[params.size()]));
        } catch (IllegalArgumentException e) {
            throw new Error(e.getMessage() + " on line " + ctx.getStart().getLine());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new Error();
        } catch (InvocationTargetException e) {
            throw new Error(e.getCause().getMessage() + " on line " + ctx.getStart().getLine());
        }
    }
}
