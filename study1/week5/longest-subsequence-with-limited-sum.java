// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
// Time Complexity: O(n^2)
// Space Complexity: O(n), n: queries.length
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];

        Arrays.sort(nums);

        for (int i = 0; i < queries.length; ++i) {
            int cnt = 0;
            int sum = 0;
            answer[i] = 0;
            for (int num : nums) {
                sum += num;
                ++cnt;
                if (sum <= queries[i]) {
                    answer[i] = cnt;
                }
            }
        }

        return answer;
    }
}