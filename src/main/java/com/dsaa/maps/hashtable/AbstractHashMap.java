package com.dsaa.maps.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dsaa.maps.map.AbstractMap;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

    protected int n = 0;
    protected int capacity;
    private final int prime;
    private final long scale, shift;
    private static final double LOAD_FACTOR = 0.5;

    public AbstractHashMap(int capacity, int prime) {
        this.prime = prime;
        this.capacity = capacity;
        Random rand = new Random();
        this.scale = rand.nextInt(prime - 1) + 1;
        this.shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, 109345121);
    }

    public AbstractHashMap() {
        this(17);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (( (double) size() / capacity) > LOAD_FACTOR) {
            resize(2 * capacity - 1);
        }
        return answer;
    }

    @Override
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCapacity) {
        List<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> e: entrySet()) {
            buffer.add(e);
        }
        this.capacity = newCapacity;
        createTable();
        this.n = 0;
        for (Entry<K, V> e: buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K key);
    protected abstract V bucketPut(int h, K key, V value);
    protected abstract V bucketRemove(int h, K key);
}
