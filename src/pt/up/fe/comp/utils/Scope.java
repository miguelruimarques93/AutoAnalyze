package pt.up.fe.comp.utils;

import java.util.HashMap;
import java.util.Map;

public class Scope<T> {
    private class Symbol {
        public Symbol(Class t, Producer init, boolean eval) {
            _type = t;
            _initializer = init;

            assert(_initializer != null);

            if (eval)
                _value = _initializer.produce();

            assert(_value != null);
        }

        public Class getType() {
            return _type;
        }

        public void init() {
            if (_value == null) _value = _initializer.produce();
        }

        public T getValue() {
            init();
            return _value;
        }

        private Producer<T> _initializer;
        private T _value = null;
        private final Class _type;
    }

    public Scope(boolean lazy) {
        _lazy = lazy;
    }

    public void addSymbol(String name, Class type, Producer<T> init) {
        if (_symbols.containsKey(name))
            throw new Error(name + " is already defined in this scope.");
        _symbols.put(name, new Symbol(type, init, !_lazy));
    }

    private Map<String, Symbol> _symbols = new HashMap<>();
    private boolean _lazy;

    public T getSymbol(String name) {
        Symbol s = _symbols.get(name);
        return s != null ? _symbols.get(name).getValue() : null;
    }

    public Class getSymbolType(String name) {
        Symbol s = _symbols.get(name);
        return s != null ? _symbols.get(name).getType() : null;
    }

    public void setLazy(boolean value) {
        _lazy = value;

        if (!_lazy)
            for (Map.Entry<String, Symbol> s : _symbols.entrySet())
                s.getValue().init();
    }
}
