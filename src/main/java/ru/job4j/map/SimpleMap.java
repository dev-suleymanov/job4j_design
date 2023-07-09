package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (capacity * LOAD_FACTOR == count) {
            expand();
        }
        int index = getIndex(key);
        boolean result = table[index] == null;
        if (result) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(K key) {
        int h = key.hashCode();
        return key == null ? 0 : h ^ h >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private boolean equalsFor(K key, int index) {
        return Objects.nonNull(table[index])
                && Objects.hashCode(key) == Objects.hashCode(table[index].key)
                && Objects.equals(key, table[index].key);
    }

    private int getIndex(K key) {
        return indexFor(hash(key));
    }
    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expandTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry: table) {
            if (Objects.nonNull(entry)) {
                expandTable[getIndex(entry.key)] = entry;
            }
        }
        table = expandTable;
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(key));
        return equalsFor(key, index) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(key);
        boolean result = equalsFor(key, index);
        if (result) {
            table[index] = null;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int cursor;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < capacity && table[cursor] == null) {
                    cursor++;
                }
                return cursor < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}