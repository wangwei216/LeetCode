//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 935 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 使用动态规划的方法进行求解：
     * 1. 首先需要想到是用一个dp[i] 数组表示 一共有i元钱，需要使用最少的dp[i] 硬币
     * 2. 然后需要想到 f（i）= f（i-所有的硬币面值的和） + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0) {
            return -1;
        }
        // i 表示amount  dp[i]表示最终的结果 就是用的最少的硬币数量
        int dp[] = new int[amount + 1];
        //
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 这里需要注意的是小于等于amout
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                // 这里是要组合的总金额，一定要 >= 金币的面值
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
