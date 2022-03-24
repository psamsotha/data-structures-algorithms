package com.dsaa.maps.hashtable;

import java.util.ArrayList;
import java.util.List;

import com.dsaa.maps.map.UnsortedTableMap;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

    private UnsortedTableMap<K, V>[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int capacity) {
        super(capacity);
    }

    public ChainHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable() {
        this.table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(key);
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            bucket = table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        V answer = bucket.put(key, value);
        n += (bucket.size() - oldSize);
        return answer;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(key);
        n -= (oldSize - bucket.size());
        return answer;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        List<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry: table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }
}
