package org.back0.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        var anagramStartIndexes = new ArrayList<Integer>();

        int[] charsCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charsCount[p.charAt(i) - 'a']++;
        }

        int windowEnd = 0;
        int windowStart = 0;
        while (windowEnd < s.length()) {
            var currChar = s.charAt(windowEnd);
            var currCharIdx = currChar - 'a';

            charsCount[currCharIdx]--;
            while (charsCount[currCharIdx] < 0) {
                charsCount[s.charAt(windowStart++) - 'a']++;
            }

            windowEnd++;

            if (windowEnd - windowStart == p.length()) {
                anagramStartIndexes.add(windowStart);
            }
        }

        return anagramStartIndexes;
    }

}
