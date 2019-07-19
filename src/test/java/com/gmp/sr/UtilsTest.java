package com.gmp.sr;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}
