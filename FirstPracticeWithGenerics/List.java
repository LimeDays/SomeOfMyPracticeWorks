package org.itstep;

import java.util.Arrays;


class List<T extends Comparable<T>> {
    private T[] arrays;
    public List() {
        this.arrays = (T[]) new Comparable[0];
    }

    public void add(T item) {
        arrays = Arrays.copyOf(arrays, arrays.length + 1);
        arrays[arrays.length - 1] = item;
    }

    public T min() {
        T min = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (min.compareTo(arrays[i]) > 0) {
                min = arrays[i];
            }
        }
        return min;
    }

    public T max () {
        T max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (max.compareTo(arrays[i]) < 0) {
                max = arrays[i];
            }
        }
        return max;
    }
}