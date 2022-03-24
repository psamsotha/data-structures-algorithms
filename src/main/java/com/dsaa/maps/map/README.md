# Map

* [Introduction](#introduction)
* [Contract](#contract)
* [Implementation](#implementation)
    * [AbstractMap](#abstractmap)
    * [UnsortedTableMap](#unsortedtablemap)


## Introduction

A **map** is an abstract data type designed to efficiently store and retrieve values based upon a uniquely identifying **search key** for each. Specifically, a map stores key value pairs _(k,v)_, which we call **entries**, where **k** is the key and **v** is its corresponding value. Keys are required to be unique, so that the association of keys to values defines a mapping.

Maps are also known as **associative arrays**, because the entry’s key serves
somewhat like an index into the map, in that it assists the map in efficiently locating the associated entry. However, unlike a standard array, a key of a map need not be numeric, and is does not directly designate a position within the structure.

## Contract

* `size()` – Returns the number of entries in _M_. 
* `isEmpty()` – Returns a boolean indicating whether _M_ is empty. 
* `get(k)` – Returns the value _v_ associated with key _k_, if such an entry exists;
  otherwise returns null.
* `put(k, v)` – If _M_ does not have an entry with key equal to _k_, then adds entry
  _(k,v)_ to _M_ and returns null; else, replaces with _v_ the existing
  value of the entry with key equal to k and returns the old value.
* `remove(k)` – Removes from _M_ the entry with key equal to _k_, and returns its
  value; if _M_ has no such entry, then returns null. 
* `keySet()` – Returns an iterable collection containing all the keys stored in _M_.
* `values()` – Returns an iterable collection containing all the values of entries
  stored in _M _(with repetition if multiple keys map to the same
  value).
* `entrySet()` – Returns an iterable collection containing all the key-value entries
  in _M_.
  
```java
public interface Map<K, V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K, V>> entrySet();

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }
}
```

## Implementation

### AbstractMap

A few methods can be implemented in the abstract base class for maps. `isEmpty()` can be determined by using the `size()` method:

```java
@Override
public boolean isEmpty() {
    return size() == 0;
}
```

The `keySet()` and `values()` methods can be implemented using the `entrySet()` method.

```java
@Override
public Iterable<K> keySet() {
    return new KeyIterable();
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
```

### UnsortedTableMap

A simple unsorted map implementation can use an `ArrayList` as the table. Each of the fundamental methods `get(k)`, `put(k, v)`, and `remove(k)` requires an
initial scan of the array to determine whether an entry with key equal to _k_ exists.

Unfortunately, the `UnsortedTableMap` class on the whole is not very efficient.
On a map with _n_ entries, each of the fundamental methods takes _O(n)_ time in the worst case because of the need to scan through the entire list when searching for an existing entry.

```java
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
```