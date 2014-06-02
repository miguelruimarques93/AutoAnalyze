package pt.up.fe.comp.utils;

import java.util.Stack;

public class SymbolTable<T> {

    public SymbolTable(boolean lazy) {
        _lazy = lazy;
        beginScope();
    }

    public void beginScope() {
        _scopes.add(new Scope<T>(_lazy));
    }

    public void endScope() {
        // do not delete "global" scope
        if (_scopes.size() > 1)
            _scopes.pop();
    }

    public void setLazy(boolean value) {
        _lazy = value;
        for (Scope<T> scp : _scopes) {
            scp.setLazy(value);
        }
    }

    public void addSymbol(String name, Class type, Producer<T> init) {
        if (!contains(name))
            _scopes.peek().addSymbol(name, type, init);
        else throw new Error(name + " is already declared.");
    }

    public boolean contains(String name) {
        return get(name) != null;
    }

    public T get(String name) {
        T value;
        for (Scope<T> scp : _scopes) {
            value = scp.getSymbol(name);
            if (value != null) return value;
        }
        return null;
    }

    public Class getType(String name) {
        Class type;
        for (Scope<T> scp : _scopes) {
            type = scp.getSymbolType(name);
            if (type != null) return type;
        }
        return null;
    }

    private Stack<Scope<T>> _scopes = new Stack<>();
    private boolean _lazy;
}
