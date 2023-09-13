package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T>{
    private List<T> data;
    private int size;
    public CyclicIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return data.size() != 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (size == data.size()) {
            size = 0;
        }
        return data.get(size++);
    }

    public static void main(String[] args) {
        CyclicIterator<Integer> cyclicIterator = new CyclicIterator<>(new ArrayList<>(List.of(1, 2, 3, 4)));
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.next());
        System.out.println(cyclicIterator.hasNext());
        System.out.println(cyclicIterator.next());
    }
}