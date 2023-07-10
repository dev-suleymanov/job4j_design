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
        if (count == capacity * LOAD_FACTOR) {
            expand();
        }
        int index = getIndex(key);
        boolean result = Objects.isNull(table[index]);
        if (result) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expandTable = new MapEntry[capacity];
        for (MapEntry<K, V> el : table) {
            if (Objects.nonNull(el)) {
                expandTable[getIndex(el.key)] = el;
            }
        }
        table = expandTable;
    }

    private boolean equalsKey(K key) {
        int index = getIndex(key);
        return Objects.nonNull(table[index])
                && Objects.hashCode(table[index].key) == Objects.hashCode(key)
                && Objects.equals(table[index].key, key);
    }

    @Override
    public V get(K key) {
        return equalsKey(key) ? table[getIndex(key)].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = equalsKey(key);
        if (result) {
            table[getIndex(key)] = null;
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