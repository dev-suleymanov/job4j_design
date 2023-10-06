package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SecureReceipt {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println("Reference: " + object);
        SoftReference<Object> softReference = new SoftReference<>(object);
        Object softObject = softReference.get();
        if (softObject != null) {
            System.out.println("SoftReference: " + softObject);
        }
        WeakReference<Object> weakReference = new WeakReference<>(object);
        Object weakObject = weakReference.get();
        if (weakObject != null) {
            System.out.println("WeakReference: " + weakObject);
        }
    }
}
