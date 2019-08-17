package com.github.binarySearch;

public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    if (null == nums || nums.length == 0) {
      return -1;
    }
    int low = 0, high = nums.length;
    while (low < high) {
      int mid=low + ((high-low) >> 1);
      if (nums[mid] >= target) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public int searchInsert1(int[] nums, int target) {
    int low = 0, high = nums.length-1;
    while(low <= high){
      int mid = low + ((high-low) >> 1);
      if(nums[mid] == target) return mid;
      else if(nums[mid] > target) {
        high = mid-1;
      }
      else {
        low = mid+1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    SearchInsertPosition sip = new SearchInsertPosition();

    int[] nums = {1,3,5};

    int target = 1;

    System.out.println(sip.searchInsert1(nums, target));
  }

}
