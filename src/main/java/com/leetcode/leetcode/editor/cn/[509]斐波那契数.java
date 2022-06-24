//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 直接使用暴力递归实现，但是会导致进行重复计算
     * 假设 db[n] 是第 n 位数字的和
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 第二种方式是把计算过的所有的值都存起来，比较占内存，这种其实是「从上而下」的递推
     */
    public int fib(int n) {
        int[] map = new int[n + 1];
        return helper(map, n);
    }

    // 返回结果
    public int helper(int[] map, int n) {
        // 首先需要考虑base case
        if (n == 0 || n == 1) {
            return n;
        }
        if (map[n] != 0) {
            return map[n];
        }
        // 直接考虑最后一步
        map[n] = helper(map, n - 1) + helper(map, n - 2);
        return map[n];
    }

    /**
     * 第三种方式直接使用 动态规划 dp 实现，其实是「自低向上」的递推
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
