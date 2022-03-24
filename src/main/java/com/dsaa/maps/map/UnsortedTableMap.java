package com.dsaa.maps.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

    private final List<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int i = findIndex(key);
        if (i == -1) return null;
        return table.get(i).getValue();
    }

    @Override
    public V put(K key, V value) {
        int i = findIndex(key);
        if (i == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(i).setValue(value);
        }
    }

    @Override
    public V remove(K key) {
        int j = findIndex(key);
        if (j == -1) {
            return null;
        }
        return table.remove(j).getValue();
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (i > table.size()) {
                throw new NoSuchElementException();
            }
            return table.get(i++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
