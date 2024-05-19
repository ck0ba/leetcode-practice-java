package org.back0.leetcode.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seenNumsSet = new HashSet<>();

        for (int num : nums) {
            if (!seenNumsSet.add(num)) {
                return true;
            }
        }

        return false;
    }
}
