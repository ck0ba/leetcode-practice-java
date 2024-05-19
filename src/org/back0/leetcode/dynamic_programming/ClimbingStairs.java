package org.back0.leetcode.dynamic_programming;

//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {

    public int climbStairs(int n) {
        var previous = 1;
        var current = 1;

        for (int i = 1; i < n; i++) {
            var tmp = previous + current;
            previous = current;
            current = tmp;
        }

        return current;
    }

}
