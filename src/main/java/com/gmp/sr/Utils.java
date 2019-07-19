package com.gmp.sr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static Map<String, String> toMap(List<KeyValue> keyValues) {
        if (keyValues == null) {
            return new HashMap<>();
        }
        return keyValues.stream()
                .collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue, (o1, o2) -> o2));
    }

    static class KeyValue {
        public String key;
        public String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
