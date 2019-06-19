package com.github.recursion;

import org.junit.Test;

public class ClimbingStairs {

    public int climbStairs1(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n -1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        return resursion(0, n);
    }

    public int resursion(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return resursion(i + 1, n) + resursion(i + 2, n);
    }

    public int climbStairs(int n) {
        int[] array = {0, 1, 2};
        for(int i = 3; i <= n; i++) {
            array[i%3] = array[(i-1)%3] + array[(i-2)%3];
        }
        return array[n%3];
    }


    @Test
    public void test () {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        int num = climbingStairs.climbStairs(2);

        System.out.println(num);

//        System.out.println(climbingStairs.climbStairs1(20));

    }

}
