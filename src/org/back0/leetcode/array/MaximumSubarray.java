package org.back0.leetcode.array;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int subarrayMax = nums[0];
        int max = subarrayMax;

        for (int i = 1; i < nums.length; i++) {
            subarrayMax = Math.max(nums[i], subarrayMax + nums[i]);
            max = Math.max(max, subarrayMax);
        }

        return max;
    }

}
