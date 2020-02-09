package com.castmart.ds;

import java.util.Arrays;
import java.util.Comparator;

public class ResizableArray<E> implements ResizableList<E> {

    private Object[] items;
    private int count;

    public ResizableArray() {
        items = new Object[2];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean add(E e) {
        if (count == items.length - 1) {
            resizeAndCopy();
        }
        items[count++] = e;
        return true;
    }

    private void resizeAndCopy() {
        Object[] newItems = new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    @Override
    public void clear() {
        for(int i = 0; i < items.length; i++) {
            items[i] = null;
            count--;
        }
    }

    @Override
    public E get(int index) {
        return (E) items[index];
    }

    @Override
    public E set(int index, E element) {
        if (index > count) {
            throw new IndexOutOfBoundsException("Not space enough");
        }
        items[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count ) throw new IndexOutOfBoundsException("Index must be positive and in the range of [0 - size]!!!");
        if (index == count) {
            // Add at the end of the array.
            add(element);
            return;
        }
        // Insert in between.
        // Insert then move all elements one slot ahead.
        Object previousUpdate = items[index];
        items[index] = element;
        count++;

        for (int i = index+1; i < count; i++ ) {
            if (count > items.length) resizeAndCopy();
            Object current = items[i];
            items[i] = previousUpdate;
            previousUpdate = current;
        }
    }

    @Override
    public void sort(Comparator<? super E> c) {
        // TODO make a custom implementation using Quicksort.
        Arrays.sort(items);
    }
}
