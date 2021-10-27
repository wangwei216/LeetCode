//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 字符串 动态规划 
// 👍 725 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一 使用动态规划进行
     * 1. 首先需要创建一个二维数组来表示  db[i][j] text1的从[1, i]之间 和 字符串text2的从[1, j]之间的最长公共子序列的值
     * 2. 都是进行倒推，先假设 dp[1-i][1-j] 中的text1的 i 位置 和text2的 j 位置都相同， dp[i][j] = dp[i-1][j-1] + 1 恒成立
     *    如果text1的最后 i 位置 和 text2的 j 位置不相同的话，因为题中要求是求最长，所以要保留两个字符串各自最大的长度那个
     * 3. 序列都是从下标1 进行开始
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // 核心的关键其实就是判断遍历中的两个字符是不是相同，因为是从下标1开始，所以要真正比较字符串的时候，需要-1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // 因为最终遍历到最后结束，其他的都是中间过程
        return dp[M][N];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
