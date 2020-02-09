package com.castmart.ds;

import org.junit.Assert;
import org.junit.Test;

public class ResizableArrayTest {

    @Test
    public void whenAddingElements_then_AllStoredWhenIteratingOverArray() {
        ResizableArray<Integer> resizableArray = new ResizableArray<>();
        int n = 2;
        for (int i = 0; i < n; i++) {
            resizableArray.add(i);
            Assert.assertEquals((Integer)i, resizableArray.get(i));
        }
    }

    @Test
    public void whenAddingElements_andHasToResize_then_AllStoredInTheSameOrder() {
        ResizableArray<Integer> resizableArray = new ResizableArray<>();    // Original size of 2.
        int[] original = new int[] {10,20,30,40,50,60,70,80,90,10};         // Ten elements will force resize twice.

        for (int i = 0; i < original.length; i++) {
            resizableArray.add(original[i]);
        }

        int[] reconstructed = new int[resizableArray.size()];
        constructArrayFromResizable(resizableArray, reconstructed);
        Assert.assertArrayEquals(original, reconstructed);
    }

    @Test
    public void whenInsertingElements_andHasToResize_then_AllStoredInTheSameOrder() {
        ResizableArray<Integer> resizableArray = new ResizableArray<>();    // Original size of 2.
        int[] original = new int[] {1,2,3,4,5,6,7};                         // Ten elements will force resize twice.
        for (int i = 0; i < original.length; i++) {
            resizableArray.add(original[i]);
        }
        // Add element at index.
        resizableArray.add(0, 0);
        int[] resultingArray = new int[resizableArray.size()];
        constructArrayFromResizable(resizableArray, resultingArray);
        int[] expected = new int[]{0,1,2,3,4,5,6,7};
        Assert.assertArrayEquals(expected, resultingArray);

        // Add element at index.
        resizableArray.add(4, 7);
        resultingArray = new int[resizableArray.size()];
        constructArrayFromResizable(resizableArray, resultingArray);
        expected = new int[]{0,1,2,3,7,4,5,6,7};
        Assert.assertArrayEquals(expected, resultingArray);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenInsertingElementAtIndexLessThanZero_then_throwException() {
        ResizableArray<Integer> resizableArray = new ResizableArray<>();    // Original size of 2.
        int[] original = new int[] {1,2,3,4,5,6,7};                         // Ten elements will force resize twice.
        for (int i = 0; i < original.length; i++) {
            resizableArray.add(original[i]);
        }
        // Add element at index.
        resizableArray.add(-1, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenInsertingElementAtIndexBiggerThanCount_then_throwException() {
        ResizableArray<Integer> resizableArray = new ResizableArray<>();    // Original size of 2.
        int[] original = new int[] {1,2,3,4,5,6,7};                         // Ten elements will force resize twice.
        for (int i = 0; i < original.length; i++) {
            resizableArray.add(original[i]);
        }
        // Add element at index.
        int index = resizableArray.size();
        resizableArray.add(index + 1, 10);
    }

    private void constructArrayFromResizable(ResizableArray<Integer> resizableArray, int[] resultingArray) {
        for (int i = 0; i < resizableArray.size(); i++) {
            resultingArray[i] = resizableArray.get(i);
        }
    }

}
