package org.back0.leetcode.string;

//https://leetcode.com/problems/valid-anagram/description/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var charCountsArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCountsArr[s.charAt(i) - 'a']++;
            charCountsArr[t.charAt(i) - 'a']--;
        }

        for (int charCount : charCountsArr) {
            if (charCount != 0) {
                return false;
            }
        }

        return true;
    }

}
