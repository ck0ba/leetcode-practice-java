package org.back0.leetcode.array;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        var numToIndex = new HashMap<Integer, Integer>();
        var res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                res[0] = numToIndex.get(target - nums[i]);
                res[1] = i;

                break;
            }

            numToIndex.put(nums[i], i);
        }

        return res;
    }

}
