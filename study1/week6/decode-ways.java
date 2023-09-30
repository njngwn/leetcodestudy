// https://leetcode.com/problems/decode-ways/
// Time Complexity: O(n), n: s.length()
// Space Complexity: O(n), n: s.length()
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {  // edge case
            return 0;
        }

        int length = s.length()+1;
        int[] cntArr = new int[length]; // using dynamic programming
        cntArr[0] = 1;

        for (int i = 1; i < length; ++i) {
            char ch = s.charAt(i-1);
            if (ch >= '1' && ch <= '9') {   // check for 1-9
                cntArr[i] += cntArr[i-1];
            }

            // check for 10-26
            if (i >= 2) {
                int num = (s.charAt(i-2)-'0') * 10 + (ch-'0');
                if (num >= 10 && num <= 26) {
                    cntArr[i] += cntArr[i-2];
                }
            }
        }

        return cntArr[length-1];
    }
}

/*
 * 12 -> (1 2) (12) => 2
 * 123 -> (1 2 3) (12 3) (1 23) => 3
 * 1234 -> (1 2 3 4) (12 34) (1 23 4) => 3
 */