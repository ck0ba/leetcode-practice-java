package org.back0.leetcode.matrix;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        var lowerCaseCnt = new int[26];
        var upperCaseCnt = new int[26];

        int sumEvens = 0;
        for (var curr : s.toCharArray()) {
            if (curr >= 'A' && curr <= 'Z') {
                if (++upperCaseCnt[curr - 'A'] % 2 == 0) {
                    sumEvens += 2;
                }
            } else {
                if (++lowerCaseCnt[curr - 'a'] % 2 == 0) {
                    sumEvens += 2;
                }
            }
        }


        for (int i = 0; i < 26; i++) {
            if (lowerCaseCnt[i] % 2 == 1 || upperCaseCnt[i] % 2 == 1) {
                return sumEvens + 1;
            }
        }

        return sumEvens;
    }
}
