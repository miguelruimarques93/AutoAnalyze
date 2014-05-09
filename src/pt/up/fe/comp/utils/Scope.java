package pt.up.fe.comp.utils;

import java.util.HashMap;
import java.util.Map;

public class Scope<T> {
    public void addSymbol(String name, T value) {
        _symbols.put(name, value);
    }

    Map<String, T> _symbols = new HashMap<>();

    public T getSymbol(String name) {
        return _symbols.get(name);
    }
}
