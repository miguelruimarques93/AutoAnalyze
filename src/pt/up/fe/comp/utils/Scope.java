package pt.up.fe.comp.utils;

import java.util.HashMap;
import java.util.Map;

public class Scope<T> {
    private class Symbol<T> {
        public Symbol(Class t, Producer<T> init) {
            _type = t;
            _initializer = init;
        }

        public Symbol(Class t, T value) {
            _type = t;
            _initializer = null;
            _value = value;
        }


        public Class getType() {
            return _type;
        }

        public T getValue() {
            if (_value == null)
                _value = _initializer != null ? _initializer.produce() : null;
            return _value;
        }

        private Producer<T> _initializer;
        private T _value = null;
        private final Class _type;
    }

    public void addSymbol(String name, Class type, Producer<T> init) {
        if (_symbols.containsKey(name))
            throw new Error(name + " is already defined in this scope.");
        _symbols.put(name, new Symbol(type, init));
    }

    public void addSymbol(String name, Class type, T value) {
        if (_symbols.containsKey(name))
            throw new Error(name + " is already defined in this scope.");
        _symbols.put(name, new Symbol(type, value));
    }

    Map<String, Symbol<T>> _symbols = new HashMap<>();

    public T getSymbol(String name) {
        Symbol<T> s = _symbols.get(name);
        return s != null ? _symbols.get(name).getValue() : null;
    }

    public Class getSymbolType(String name) {
        Symbol<T> s = _symbols.get(name);
        return s != null ? _symbols.get(name).getType() : null;
    }
}
