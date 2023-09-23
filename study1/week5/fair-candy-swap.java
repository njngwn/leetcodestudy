// https://leetcode.com/problems/fair-candy-swap/
// Time Complexity: O(n*m), n: aliceSizes.length, m: bobSizes.length
// Space Complexity: O(1)
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        for (int a : aliceSizes) { aliceSum += a; }
        for (int b : bobSizes) { bobSum += b; }

        int difference = (aliceSum - bobSum)/2;

        for (int a = aliceSizes.length-1; a >= 0; --a) {
            for (int b = 0; b < bobSizes.length; ++b) {
                if (aliceSizes[a]-bobSizes[b] == difference) {
                    return new int[]{aliceSizes[a], bobSizes[b]};
                }
            }
        }

        return new int[]{0, 0};
    }
}
