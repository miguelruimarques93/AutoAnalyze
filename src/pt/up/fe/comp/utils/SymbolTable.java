package pt.up.fe.comp.utils;

import java.util.Stack;

public class SymbolTable<T> {

    public SymbolTable() {
        beginScope();
    }

    public void beginScope() {
        _scopes.add(new Scope<T>());
    }

    public void endScope() {
        // do not delete "global" scope
        if (_scopes.size() > 1)
            _scopes.pop();
    }

    public void addSymbol(String name, Class type, Producer<T> init) {
        _scopes.peek().addSymbol(name, type, init);
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
}
