package com.github.array;

public class Traverse {

    // 二分查找的递归实现
    public int bsearch(int[] a, int val) {
        return bsearchInternally(a, 0, a.length - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }


    public int binarySearch (int[] nums, int value) {
        if (nums.length == 0) {
            return -1;
        }
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (nums[mid] == value) {
                return mid;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 如何在 1000 万个整数中快速查找某个整数？内存限制是 100MB
     *
     * 内存限制是 100MB，每个数据大小是 8 字节，最简单的办法就是将数据存储在数组中，内存占用差不多是 80M.
     *
     * @param args
     */
    public static void main(String[] args) {
        Traverse t = new Traverse();

        final int NUMBER = 10000000;
        int[] nums = new int[NUMBER];
        for (int i = 0; i < NUMBER; i++) {
            nums[i] = i;
        }
        long head = System.currentTimeMillis();
        System.out.println(t.binarySearch(nums, 10));
//        System.out.println(t.binarySearch(nums, 5));
        long tail = System.currentTimeMillis();
        System.out.println("have " + (tail - head) + " ms");
    }

}
