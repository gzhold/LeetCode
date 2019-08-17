package com.github.binarySearch;

import org.junit.Test;

public class CodeFramework {


  public int findFirst(int[] nums, int value) {
    if (null == nums) {
      return -1;
    }
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid =  low + ((high - low) >> 1);
      if (nums[mid] > value) {
        high = mid - 1;
      } else if (nums[mid] < value) {
        low = mid + 1;
      } else {
        if ((mid == 0) || (nums[mid - 1] != value) ) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }


  public int findLast(int[] nums, int value) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] < value) {
        low = mid + 1;
      } else if (nums[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == nums.length -1) || (nums[mid + 1] != value)) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }


  /**
   * 查找第一个大于等于指定值的元素
   * @param nums
   * @param value
   * @return
   */
  public int bsearch(int[] nums, int value) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid =  low + ((high - low) >> 1);
      if (nums[mid] >= value) {
        if ((mid == 0) || (nums[mid - 1] < value))
          return mid;
        else
          high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }


  /**
   * 查找最后一个小于等于指定值的元素
   * @param nums
   * @param value
   * @return
   */
  public int findLastMinOrEqual(int[] nums, int value) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] > value) {
        high = mid - 1;
      } else {
        if (mid == nums.length -1 || nums[mid + 1] > value) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }


  @Test
  public void testFindFirst() {
    int[] nums = {1,3,4,5,6,8,8,8,11,18};
    int value = 8;

    CodeFramework cf = new CodeFramework();
    System.out.println("first element : " + cf.findFirst(nums, value));

    System.out.println("last element : " + cf.findLast(nums, value));

    int[] temp = {3, 4, 6, 7, 10};
    System.out.println(cf.bsearch(temp, 4));

    System.out.println(cf.findLastMinOrEqual(temp, 8));
  }


}
