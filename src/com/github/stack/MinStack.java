package com.github.stack;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by admin on 2019/五月/5.
 */
public class MinStack {
    private volatile int min = -1;
    private volatile int count = 0;
    private Integer[] arrays;


    /** initialize your data structure here. */
    public MinStack() {
        arrays = new Integer[10];
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        try {
            arrays = checkSize(arrays);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrays[count] = x;
        count = count + 1;
        if (count == 1) {
            min = x;
        }
    }

    private Integer[] checkSize (Integer[] arrays) throws Exception {
        if (count == arrays.length) {
            if (2 * arrays.length >= Integer.MAX_VALUE) {
                throw new Exception("Exceeding maximum length！");
            }
            Integer[] newArrays = Arrays.copyOf(arrays, 2 * arrays.length);
            return newArrays;
        }
        return arrays;
    }

    public void pop() {
        count = count - 1;
        if (count < 0) {
            throw new IndexOutOfBoundsException("index error");
        }
        if (arrays[count] == min) {
            min = arrays[0];
        }
        arrays[count] = null;
        // O(n)
        for (int i = 0; i < count; i++) {
            if (arrays[i] < min) {
                min = arrays[i];
            }
        }
    }

    public int top() {
        if (count - 1 < 0) {
            throw new IndexOutOfBoundsException("index error");
        }
        return arrays[count - 1];
    }

    public int getMin() {
        return min;
    }


    @Test
    public void test () {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // Returns -3.
        System.out.println(minStack.getMin());
        minStack.pop();
        // Returns 0.
        System.out.println(minStack.top());
        // Returns -2.
        System.out.println(minStack.getMin());
    }


    @Test
    public void test1 () {
        MinStack minStack = new MinStack();
        minStack.push(-1);

        // Returns -1.
        System.out.println(minStack.top());
        // Returns -1.
        System.out.println(minStack.getMin());
    }

    @Test
    public void test3 () {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        // Returns -2.
        System.out.println(minStack.getMin());
        // Returns -1.
        System.out.println(minStack.top());

        minStack.pop();
        // Returns -2.
        System.out.println(minStack.getMin());
    }

    @Test
    public void test4 () {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

}
