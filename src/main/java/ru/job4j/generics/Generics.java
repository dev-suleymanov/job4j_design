package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();


        /**
         * Так как метод printBoundedWildCard имеет ограничение сверху классом Predator,
         * то в данном случает могут быть использованы объекты класса Predator и Tiger
         * generics.printBoundedWildCard(first) - недопустимо;
         */
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        /**
         * Так как метод printLowerBoundedWildCard имеет ограничение снизу классом Predator,
         * то в данном случает могут быть использованы объекты класса Animal и Predator
         * generics.printLowerBoundedWildCard(third) - недопустимо;
         */
    }

    public void printObject(List<?> list) {
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Current element: " + next);
        }
    }
}