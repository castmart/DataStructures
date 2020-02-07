package com.castmart.ds;

public interface Table<K, T> {

    void put(K key, T value);

    T get(K key);

    void remove(K key);

    default int size() {
        return 0;
    };
}
