//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 657 👎 0


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种使用回溯的暴力法进行去解决
     * 1. 利用输入的值减去
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        return helper(n, new HashMap<Integer, Integer>());
    }

    public int helper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 0) {
            return 0;
        }
        int cout = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            cout = Math.min(cout, helper(n - i * i, map) + 1);
        }
        map.put(n, cout);
        return cout;
    }

    /**
     * 第二种是使用动态规划进行解决的
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
