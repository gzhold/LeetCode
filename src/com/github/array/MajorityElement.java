package com.github.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * Created by admin on 2019/四月/9.
 */
public class MajorityElement {

    /**
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     *
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int num : nums) {
            if (tempMap.containsKey(num)) {
                tempMap.put(num, tempMap.get(num) + 1);
            } else {
                tempMap.put(num, 1);
            }
        }
        int index = -1;
        int count = -1;
        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            int value = entry.getValue().intValue();
            if (value > count) {
                count = value;
                index = entry.getKey().intValue();
            }
        }
        return index;
    }


    public static int majorityElement1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        // 可考虑快排 O(nlogn)
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }



    public static void main(String[] args) {
        int[] arrays = {2,2,1,1,1,2,2};
//        int[] arrays = {3,2,3};
        System.out.println(majorityElement1(arrays));
    }

}
