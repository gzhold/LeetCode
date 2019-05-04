package com.github.array;


/**
 * https://leetcode.com/problems/first-missing-positive/
 * Created by admin on 2019/四月/16.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] arrays = {3,4,-1,1};
        int min = firstMissingPositive1(arrays);
        System.out.println("min = " + min);
    }

    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     * Example 1:
     *      Input: [1,2,0]
     *      Output: 3
     * Example 2:
     *      Input: [3,4,-1,1]
     *      Output: 2
     * Example 3:
     *      Input: [7,8,9,11,12]
     *      Output: 1
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        if (null == nums || 0 == nums.length)
            return -1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length)
                i++;
            else if (nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
            else i++;
        }
        for (int j : nums) {
            System.out.println(j + " ");
        }
        return -1;
    }

    public static int firstMissingPositive1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 1;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length)
                i++;
            else if (nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
            else i++;
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1)
            i++;
        return i+1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
