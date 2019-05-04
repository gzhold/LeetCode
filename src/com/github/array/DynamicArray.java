package com.github.array;


import java.util.Arrays;
import java.util.Random;

/**
 * Created by admin on 2019/四月/22.
 */
public class DynamicArray {

    private Integer[] array;

    private volatile int index = 0;


    public DynamicArray() {
        this.array = new Integer[10];
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("parameters are illegal.");
        } else if (capacity == 0) {
            this.array = new Integer[10];
        } else {
            this.array = new Integer[capacity];
        }
    }

    public int index() {
        return index;
    }


    public void add (Integer value) {
        int length = array.length;
        if (index == length) {
            int newLength = length << 1;
            if (newLength >= Integer.MAX_VALUE) {
                return;
            }
            array = Arrays.copyOf(array, newLength);
        }
        array[index++] = value;
    }


    public void remove (Integer value) {
        if (array.length == 0) {
            return;
        }
        Integer markIndex = null;
        for (int i = 0;i < array.length; i++) {
            if (array[i] == value) {
                markIndex = i;
                break;
            }
        }
        if (null != markIndex) {
            for (int i = markIndex; i < array.length; i++) {
                if (i +1 >= array.length) {
                    array[i] = null;
                    break;
                }
                array[i] = array[i+1];
            }
            index--;
        }
    }


    public Integer get (int k) {
        return array[k];
    }


    public Integer get (Integer value) {
        for (int num : array) {
            if (num == value)
                return num;
        }
        return null;
    }


    public void set (Integer origin, Integer newValue) {
        if (origin == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == origin) {
                array[i] = newValue;
            }
        }
    }


    public void set (int i, Integer newValue) {
        if (newValue == null) {
            return;
        }
        array[i] = newValue;
    }



    public String toString() {
        StringBuilder builder = new StringBuilder(array.length);
        for (Integer n : array) {
            if (n == null) {
                builder.append(" * ");
            } else {
                builder.append(String.valueOf(n));
                builder.append(" ");
            }
        }
        return builder.toString();
    }



    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        foreachAdd(dynamicArray);

//        dynamicArray.add(4);
//        dynamicArray.add(9);
//        dynamicArray.add(1);
//        dynamicArray.add(3);
//        dynamicArray.add(8);
//        dynamicArray.add(6);
//        dynamicArray.add(2);
//        dynamicArray.add(5);
//        dynamicArray.add(7);
//        dynamicArray.add(10);
//        dynamicArray.add(12);
//        System.out.println(dynamicArray.toString());
//        System.out.println(dynamicArray.index());
//
//        System.out.println(" ----------------------");
//        dynamicArray.remove(8);
//        System.out.println(dynamicArray.toString());
//        System.out.println(dynamicArray.index());
    }


    public static void foreachAdd (DynamicArray dynamicArray) {
        long startTime = System.currentTimeMillis();
        int num = 0;
        int max = 10000000;
        Random rand =new Random();
        while(num < max) {
            dynamicArray.add(rand.nextInt(max));
            ++num;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("add data time  = " + (endTime-startTime));
    }


}
