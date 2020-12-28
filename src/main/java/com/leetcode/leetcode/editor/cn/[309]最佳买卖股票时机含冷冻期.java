//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 611 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法使用动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 这里把股票分成三种情况进行计算利润
        // 二维数组中Y位置表示如下：
        // 0 持股状态、
        // 1 不持股的冷冻期状态、
        // 2 不持股的卖出状态
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len + 1][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 0 持股状态的两种情况： 1. 继续保持持股 算上今天的收益，2. 前天清仓了昨天是冷冻期，然后今天刚买入
            dp[i][0] = Math.max(dp[i - 1][0] , dp[i-1][2] - prices[i]);
            // 1 不持股冷冻期状态： 今天是冷冻卖出状态： 其实就是昨天持股今天卖出
            dp[i][1] = dp[i-1][0] + prices[i];
            // 2 不持股的卖出状态
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
        }
        // 返回两种不持股的卖出状态
        return Math.max(dp[plen-1][1],dp[plen-1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
