class Solution {
    private int start, maxLen;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // odd
            expand(s, i, i + 1);   // even
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}
