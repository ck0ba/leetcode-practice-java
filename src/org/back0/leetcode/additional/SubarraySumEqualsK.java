package org.back0.leetcode.additional;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int result = 0;

        var prefixSumMap = new HashMap<Integer, Integer>();
        prefixSumMap.put(0, 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += prefixSumMap.getOrDefault(sum - k, 0);
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
