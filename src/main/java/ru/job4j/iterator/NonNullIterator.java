package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonNullIterator implements Iterator<Integer> {

    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && Objects.isNull(data[index])) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public static void main(String[] args) {
        NonNullIterator nonNullIterator = new NonNullIterator(new Integer[]{null, null, 2, null, null, null, -4, null, 6, null});
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.next());
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.next());
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.next());
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.hasNext());
        System.out.println(nonNullIterator.next());
    }
}