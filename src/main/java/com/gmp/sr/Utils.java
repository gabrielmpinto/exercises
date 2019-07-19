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

    public static String mostUsedValue(Map<String, String> map) {
        if (map == null) {
            return null;
        }

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String value : map.values()) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        String maxValue = null;
        int maxValueFrequency = -1;
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxValueFrequency) {
                maxValue = entry.getKey();
                maxValueFrequency = entry.getValue();
            }
        }

        return maxValue;
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
