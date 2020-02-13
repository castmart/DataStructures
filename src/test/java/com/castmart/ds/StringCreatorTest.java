package com.castmart.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCreatorTest {

    StringCreatorImpl tool;

    @Before
    public void init() {
        tool = new StringCreatorImpl();
    }

    @Test
    public void testAppendSingleString() {
        String s1 = "One";
        tool.append(s1);
        Assert.assertEquals(s1, tool.toString());
    }

    @Test
    public void testAppendString() {
        String s1 = "One";
        String s2 = "Two";
        tool.append(s1).append(" ").append(s2);
        Assert.assertEquals("One Two", tool.toString());
    }

    @Test
    public void testUpfrontSingleString() {
        String s1 = "One";
        tool.insertUpfront(s1);
        Assert.assertEquals(s1, tool.toString());
    }

    @Test
    public void testUpfrontString() {
        String s1 = "One";
        String s2 = "Two";
        tool.insertUpfront(s1).insertUpfront(" ").insertUpfront(s2);
        Assert.assertEquals("Two One", tool.toString());
    }
}
