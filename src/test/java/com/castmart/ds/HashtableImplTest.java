package com.castmart.ds;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashtableImplTest {

    HashtableImpl<String, String> hashtable;

    @Before
    public void init() {
        hashtable = new HashtableImpl<>(0, 0.5f);
    }

    @Test
    public void checkGettingSameObject_after_insert() {
        String key = "key";
        String value = "Jhon";

        hashtable.put(key, value);

        String valueAfter = hashtable.get(key);

        Assert.assertEquals(value, valueAfter);
    }

    @Test
    public void whenDifferentKeys_then_allInserted() {
        int NUM_INSERTIONS = 20;
        for (int i = 0; i < NUM_INSERTIONS; i++) {
            hashtable.put("K"+i, "V"+i);
        }
        Assert.assertEquals(NUM_INSERTIONS, hashtable.size());
    }
}
