package com.github.binarySearch;

import org.junit.Test;

/**
 * O(logN)
 */
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (null == matrix || matrix.length == 0) {
      return false;
    }
    for (int[] nums : matrix) {
      if (null == nums || nums.length == 0) {
        continue;
      }
      int low = 0, high = nums.length - 1;
      if (target >= nums[low] && nums[high] >= target) {
        while (low <= high){
          int mid = low + ((high - low) >> 1);
          if (target == nums[mid]) {
            return true;
          } else if (nums[mid] > target) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      } else {
        continue;
      }
    }
    return false;
  }


  @Test
  public void test() {
    int[][] matrix = {
        {1,   3,  5,  7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };

    SearchA2DMatrix sm = new SearchA2DMatrix();
    System.out.println(sm.searchMatrix(matrix, 3));
  }

}
