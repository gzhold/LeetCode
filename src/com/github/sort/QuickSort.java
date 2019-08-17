package com.github.sort;

import java.util.Random;

public class QuickSort {


  public void quickSort(int[] arrays) {
    if(null == arrays || arrays.length == 0) {
      return;
    }
    qsort(arrays, 0, arrays.length-1);

  }

  private void qsort(int[] arrays, int p, int r) {
    if (p >= r) {
      return;
    }
    int q = partition(arrays, p, r); // 获取分区点
    qsort(arrays, p, q-1);
    qsort(arrays, q+1, r);
  }


  private int partition(int[] a, int p, int r) {
    int pivot = a[r];
    int i = p;
    for(int j = p; j < r; ++j) {
      if (a[j] < pivot) {
        if (i == j) {
          ++i;
        } else {
          int tmp = a[i];
          a[i++] = a[j];
          a[j] = tmp;
        }
      }
    }

    int tmp = a[i];
    a[i] = a[r];
    a[r] = tmp;
    return i;
  }

  public static void main(String[] args) {
    final int COUNT = 10;
    int[] nums = new int[COUNT];
    Random random = new Random();
    for (int i = 0;i < COUNT; i++) {
      nums[i] = random.nextInt(COUNT);
    }
    long head  = System.currentTimeMillis();
    new QuickSort().quickSort(nums);
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
