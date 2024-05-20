package org.back0.leetcode.additional;

public class CheckIAllCharactersHaveEqualNumberOfOccurrences {

    public boolean areOccurrencesEqual(String s) {
        var charCountsArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCountsArr[s.charAt(i) - 'a']++;
        }

        int targetCount = charCountsArr[s.charAt(0) - 'a'];

        for (int charCount : charCountsArr) {
            if (charCount != 0 && targetCount != charCount) {
                return false;
            }
        }

        return true;
    }
}
