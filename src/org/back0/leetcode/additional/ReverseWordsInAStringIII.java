package org.back0.leetcode.additional;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0, j = 1; j <= n; j++) {
            if (j == n || c[j] == ' ') {
                reverseChars(c, i, j - 1);
                i = j + 1;
            }
        }

        return new String(c);
    }

    private void reverseChars(char[] charsArr, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = charsArr[i];
            charsArr[i] = charsArr[j];
            charsArr[j] = tmp;
        }
    }
}
