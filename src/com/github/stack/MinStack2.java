package com.github.stack;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by admin on 2019/五月/5.
 */
public class MinStack2 {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }


    @Ignore
    public void test4 () {
        MinStack2 minStack = new MinStack2();
        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }


    @Test
    public void test () {
        MinStack2 minStack = new MinStack2();
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
}
