package com.gmp.sr;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void toMapNullList() {
        Map<String, String> map = Utils.toMap(null);
        assertTrue(map.isEmpty());
    }

    @Test
    public void toMapEmptyList() {
        Map<String, String> map = Utils.toMap(new ArrayList<>());
        assertTrue(map.isEmpty());
    }

    @Test
    public void toMap() {
        ArrayList<Utils.KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new Utils.KeyValue("key", "value"));
        Map<String, String> map = Utils.toMap(keyValues);
        assertEquals(1, map.size());
        assertTrue(map.containsKey("key"));
        assertEquals("value", map.get("key"));
    }

    @Test
    public void toMapMultiple() {
        ArrayList<Utils.KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new Utils.KeyValue("key", "value"));
        keyValues.add(new Utils.KeyValue("key2", "value2"));
        Map<String, String> map = Utils.toMap(keyValues);
        assertEquals(2, map.size());
        assertTrue(map.containsKey("key"));
        assertEquals("value", map.get("key"));
    }

    @Test
    public void toMapRepeated() {
        ArrayList<Utils.KeyValue> keyValues = new ArrayList<>();
        keyValues.add(new Utils.KeyValue("key", "value"));
        keyValues.add(new Utils.KeyValue("key", "value2"));
        Map<String, String> map = Utils.toMap(keyValues);
        assertEquals(1, map.size());
        assertTrue(map.containsKey("key"));
        assertEquals("value2", map.get("key"));
    }

    @Test
    public void mostUsedNull() {
        assertNull(Utils.mostUsedValue(null));
    }

    @Test
    public void mostUsedEmpty() {
        assertNull(Utils.mostUsedValue(Collections.emptyMap()));
    }

    @Test
    public void mostUsed() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value2");
        map.put("key4", "value2");
        map.put("key5", "value2");
        assertEquals("value2", Utils.mostUsedValue(map));
    }

    @Test
    public void mostUsedEqual() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        assertEquals("value5", Utils.mostUsedValue(map));
    }
}
