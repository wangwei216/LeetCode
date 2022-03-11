//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 560 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 优先考虑使用动态规划方法
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 这里的 dp[m][n] 表示 nums1中 从1 到m 和 nums2 中从1 到n之间的最长连续子数组
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 判断的时候虽然是从1开始，但是判断的时候还是要从数组的 0 下标开始的，相同的时候，就更新结果集合
                if (nums1[i-1] == nums2[j-1]) {
                    // 因为是倒着去找相同的
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
