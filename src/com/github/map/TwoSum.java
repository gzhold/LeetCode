package com.github.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2019/二月/17.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        TwoSum ts = new TwoSum();
        int[] ss = ts.twoSum(nums, target);

        for (int k : ss) {
            System.out.println(k);
        }

    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 1) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

}
