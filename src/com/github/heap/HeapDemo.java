package com.github.heap;

public class HeapDemo {


  public static void main(String[] args) {
    HeapDemo hd = new HeapDemo();

    int[] nums = {3,2,3,1,2,4,5,5,6};

    Heap heap = hd.new Heap(nums.length);
    for(int n : nums){
      heap.insert(n);
    }

    System.out.println(heap.get(4));

  }


  public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
      a = new int[capacity + 1];
      n = capacity;
      count = 0;
    }

    /**
     * time: O(logn)
     * @param data
     */
    public void insert(int data) {
      if (count >= n) return; // 堆满了
      ++count;
      a[count] = data;
      int i = count;
      while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
        swap(a, i, i/2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
        i = i/2;
      }
    }


    protected void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    protected int get(int k) {
      if(k >= a.length) {
        return -1;
      }
      return a[k];
    }


    /**
     * time: O(logn)
     */
    public void removeMax() {
      if (count == 0) return; // 堆中没有数据
      a[1] = a[count];
      --count;
      heapify(a, count, 1);
    }


    /**
     * 堆化
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) { // 自上往下堆化
      while (true) {
        int maxPos = i;
        if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
        if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
        if (maxPos == i) break;
        swap(a, i, maxPos);
        i = maxPos;
      }
    }


  }


}


