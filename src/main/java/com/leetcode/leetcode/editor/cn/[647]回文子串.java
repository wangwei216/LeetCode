//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 446 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方法是使用的是二维数组进行的动态规划的方式
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len + 1][len + 1];
        // 这里需要把二维数组进行填充false
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
        int count = 0;
        // 首先需要考虑的是 其实就是看字符串字串S【i ~ j】是不是回文串，所以隐藏的一个条件就是i <= j
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //这种情况是单个字符的时候
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                    //这个是处理两个字符的时候
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                    // （这是处理多个字符的时候）当进行填表当dp[i][j]的时候，需要保证对角的值已经也是计算过的，其实就是字符串的内层也必须要是相同的，类似拨洋葱一样
                } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 第二种方式是对二维动态规划数组进行压缩成一维数组进行把O（N* N）时间复杂度降低到O(N)时间复杂度
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        Boolean[] dp = new Boolean[len + 1];

        int count = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j){
                    dp[i] = true;
                    count++;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i] = true;
                    count++;
                } else if (j - i > 1 && s.charAt(i) == s.charAt(j) && dp[i+1]) {
                    dp[i] = true;
                    count++;
                } else {
                    dp[i] = false;
                }
            }
        }
        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
