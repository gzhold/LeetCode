package com.github.binarySearch;

import org.junit.Test;

public class SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        if (nums[low] <= nums[mid] && nums[low] > target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        if (nums[high] >= nums[mid] && nums[high] < target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }



  public boolean bsearch(int[] nums, int target) {
    if (null == nums || nums.length == 0) {
      return false;
    }
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (nums[mid] == target) {
        return true;
      }
      //if left part is sorted
      if( nums[low] < nums[mid]) {
        if (target < nums[low] || target > nums[mid]) {
          //target is in rotated part
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else if (nums[low] > nums[mid]){
        //right part is rotated

        //target is in rotated part
        if (target < nums[mid] || target > nums[high]) {
          high = mid -1;
        } else {
          low = mid + 1;
        }
      } else {
        //duplicates, we know nums[mid] != target, so nums[head] != target
        //based on current information, we can only move left pointer to skip one cell
        //thus in the worest case, we would have target: 2, and array like 11111111, then
        //the running time would be O(n)
        low ++;
      }
    }
    return false;
  }



  @Test
  public void test() {
    SearchInRotatedSortedArray sirs = new SearchInRotatedSortedArray();

    int[] nums = {4,5,6,7,0,1,2};

    int target = 0;

    System.out.println(sirs.search(nums, target));

  }


  @Test
  public void testBsearch() {
    SearchInRotatedSortedArray sirs = new SearchInRotatedSortedArray();

//    int[] nums = {1, 1, 3, 1}; target = 3;
    int[] nums = {2,5,6,0,0,1,2};

    int target = 3;

    System.out.println(sirs.bsearch(nums, target));

  }

}
