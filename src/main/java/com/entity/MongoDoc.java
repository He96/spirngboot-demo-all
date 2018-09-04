package com.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Document(collection = "test")
public class MongoDoc extends HashMap{
    public MongoDoc(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public MongoDoc(int initialCapacity) {
        super(initialCapacity);
    }

    public MongoDoc() {
        super();
    }

    public MongoDoc(Map m) {
        super(m);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    @Override
    public void putAll(Map m) {
        super.putAll(m);
    }

    @Override
    public Object remove(Object key) {
        return super.remove(key);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return super.containsValue(value);
    }

    @Override
    public Set keySet() {
        return super.keySet();
    }

    @Override
    public Collection values() {
        return super.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return super.entrySet();
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        return super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        return super.replace(key, oldValue, newValue);
    }

    @Override
    public Object replace(Object key, Object value) {
        return super.replace(key, value);
    }

    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        return super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        return super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        return super.compute(key, remappingFunction);
    }

    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        return super.merge(key, value, remappingFunction);
    }

    @Override
    public void forEach(BiConsumer action) {
        super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction function) {
        super.replaceAll(function);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
