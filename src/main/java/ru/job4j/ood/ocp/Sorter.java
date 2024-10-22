package ru.job4j.ood.ocp;

public class Sorter {
    public void sort(int[] array, String sortType) {
        if ("bubble_sort".equals(sortType)) {
            System.out.println("Реализация сортировки пузырьками");
        } else if ("selection_sort".equals(sortType)) {
            System.out.println("Реализация сортировки выбором");
        } else if ("merge_sort".equals(sortType)) {
            System.out.println("Реализация сортировки слиянием");
        } else {
            throw new IllegalArgumentException("Unknown sorting type: " + sortType);
        }
    }
}
