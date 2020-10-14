//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1. 通过倒推确定最后一步的最优解然后确定转移方程
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //第一种情况，如果只有一个值的话
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                //当i = 0时，机器人只能向下走，因此dp[i][j] = dp[i][j-1] + grid[i][j];
                //当j = 0时，机器人只能向右走，因此dp[i][j] = dp[i-1][j] + grid[i][j];
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (){
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
