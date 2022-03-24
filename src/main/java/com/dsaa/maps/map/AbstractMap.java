package com.dsaa.maps.map;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }

    private class KeyIterable implements Iterable<K> {

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    private class KeyIterator implements Iterator<K> {

        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    private class ValueIterator implements Iterator<V> {

        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected static class MapEntry<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        protected MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        protected V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, V> entry: entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
