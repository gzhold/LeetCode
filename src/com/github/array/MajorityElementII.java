package com.github.array;


import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 * Example 1:

 Input: [3,2,3]
 Output: [3]
 Example 2:

 Input: [1,1,1,3,3,2,2,2]
 Output: [1,2]
 * Created by admin on 2019/四月/9.
 */
public class MajorityElementII {

    /**
     *  algorithm detail
     * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        if (null == nums || nums.length ==0) {
            return null;
        }
        int candidateA = 0, candidateB = 1;
        int countA = 0, countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
                continue;
            }
            if (num == candidateB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }
        List<Integer> list = new LinkedList<>();
        if (countA > nums.length / 3) {
            list.add(candidateA);
        }
        if (countB > nums.length / 3) {
            list.add(candidateB);
        }
        return list;
    }

    public static void main(String[] args) {
        int [] arrays = {3,0,3,4};
//        int[] arrays = {1};
//        int[] arrays = {3,2,3};
//        int[] arrays = {1,1,1,3,3,2,2,2};
//        int[] arrays = {4,4,4,3,3,2,2,2};
        List<Integer> list = majorityElement(arrays);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
