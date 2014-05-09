package pt.up.fe.comp.utils;

import java.util.*;

public class SymbolTable<T> {

    public void beginScope() {
        _scopes.add(new Scope<T>());
    }

    public void endScope() {
        _scopes.pop();
    }

    public void addSymbol(String name, T value) {
        _scopes.peek().addSymbol(name, value);
    }

    public T get(String name) {
        T value;
        for (Scope<T> scp: _scopes) {
            value = scp.getSymbol(name);
            if (value != null) return value;
        }
        return null;
    }

    private Stack<Scope<T>> _scopes = new Stack<>();
}
