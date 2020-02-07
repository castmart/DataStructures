package com.castmart.ds;

public class HashtableImpl<K,V> implements Table<K, V> {

    private TableRecord<K, V>[] values;
    private float growthFactor;

    private int count = 0;

    public HashtableImpl(int initialSize, float growthFactor) {
        values = new TableRecord[initialSize > 0 ? initialSize : 10];
        this.growthFactor = growthFactor;
    }

    @Override
    public void put(K key, V value) {
        // Check capacity
        if (shouldResize()) {
            resize();
        }
        // Lets see the the computed index.
        int index = computedIndex(key);
        // If there are values, then override.
        TableRecord<K, V> currentElement = values[index];
        if (currentElement == null) {
            // Insert it.
            values[index] = new TableRecord<K, V>(key, value);
            count++;
        } else {
            System.out.println("Computed index ["+index+"] for " + key + ":" + value + " - tries to override element: " + currentElement.getK() + ":" + currentElement.getV() + " operation not allowed.");
        }
    }

    private boolean shouldResize() {
        return ( (float) count/values.length ) >= growthFactor;
    }

    private void resize() {
        System.out.printf("We need to resize storage porcentage: %1.2f\n", new Object[]{ ((float)count/values.length)});
        TableRecord<K, V>[] doubleSizeArray = new TableRecord[values.length * 2];
        for (int i = 0; i < values.length; i++) {
            int index = values[i] != null ? (values[i].getK().hashCode() % doubleSizeArray.length) : -1;
            if (index >= 0) {
                doubleSizeArray[index] = values[i];
                values[i] = null;
            }
        }
        values = doubleSizeArray;
    }

    private int computedIndex(K key) {
        return key.hashCode() % values.length;
    }

    @Override
    public V get(K key) {
        int index = computedIndex(key);
        return values[index].getV();
    }

    @Override
    public void remove(K key) {
        int index = computedIndex(key);
        values[index] = null;
        count--;
    }

    @Override
    public int size() {
        return count;
    }
}
