package com.castmart.ds;

public class TableRecord<K, V> {

    K k;
    V v;

    public TableRecord(K key, V value) {
        this.k = key;
        this.v = value;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    @Override
    public int hashCode() {
        return k.hashCode();
    }

}
