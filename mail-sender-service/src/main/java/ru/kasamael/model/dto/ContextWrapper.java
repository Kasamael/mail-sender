package ru.kasamael.model.dto;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class ContextWrapper {

    private final Map<String, Object> values;

    public Object get(String name) {
        if (!values.containsKey(name)) {
            throw new RuntimeException("VALUE_NOT_FOUND_IN_ARGS");
        }
        return values.get(name);
    }
}
