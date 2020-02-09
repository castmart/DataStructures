package com.castmart.ds;

import java.util.Comparator;

public interface ResizableList<E> {

    public int size();

    public boolean isEmpty();

    public boolean add(E e);

    public void clear();

    public E get(int index);

    public E set(int index, E element);

    public void add(int index, E element);

    public void sort(Comparator<? super E> c);
}
