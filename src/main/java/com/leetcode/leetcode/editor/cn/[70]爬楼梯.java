//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 这里其实就是一个典型的动态规划问题
     * 可以直接假设
     * 1. 爬上 n-1 阶楼梯的方法数量。因为再爬1阶就能到第n
     * 2. 爬上 n-2 阶楼梯的方法数量。因为再爬2阶就能到第n
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 这里表示爬上n阶楼梯，需要dp[n]中方法
        int[] dp = new int[];
        // 这个是base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 这个递推关系式其实是推断出来的，从前面两个值中加起来
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 第二种使用递归法的优化法，因为递归会比较费时间，然后优化就是使用一个数组保存之前计算的结果
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] memory = new int[n + 1];
        return dfs(n, memory);
    }

    public int dfs(int n, int[] memory) {
        if (memory[n] > 0) {
            return memory[n];
        }
        if (n == 1) {
            memory[1] = 1;
        } else if (n == 2) {
            memory[n] = 2;
        } else {
            memory[n] = dfs(n - 1, memory[n]) + dfs(n - 2, memory[n])
        }
        return memory[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
