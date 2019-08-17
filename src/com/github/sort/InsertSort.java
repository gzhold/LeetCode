package com.github.sort;

import java.util.Random;

public class InsertSort {


  public static void insertSort(int[] arrays) {
    if(null == arrays || arrays.length == 0) {
      return;
    }
    int j = 0;
    for(int i = 1;i < arrays.length; i++) {
      int t = arrays[i];
      for (j = i; j > 0 && arrays[j-1] > t; j--) {
        arrays[j] = arrays[j-1];
      }
      arrays[j] = t;
    }
  }

  public static void main(String[] args) {
    final int COUNT = 500000;
    int[] nums = new int[COUNT];
    Random random = new Random();
    for (int i = 0;i < COUNT; i++) {
      nums[i] = random.nextInt(COUNT);
    }
    long head  = System.currentTimeMillis();
    insertSort(nums);
    long tail = System.currentTimeMillis();
    System.out.println("have time " + (tail - head) + " ms");
    print(nums);
  }

  public static void print(int[] arrays) {
    if(arrays.length == 0) {
      return;
    }
    for(int n : arrays) {
      System.out.print(n + " ");
    }
  }

}
