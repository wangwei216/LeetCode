//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 这个是使用中心扩散法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxLen = 1;
        if (s.length() < 2) {
            return s;
        }
        String resuslt = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                resuslt = maxLenStr;
            }
        }
        return resuslt;
    }

    private String centerSpread(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }


    /**
     * 这个是使用动态规划进行的
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        //dp[i][j]中i -> j表示是不是回文串
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; i++) {
                int j = i + 1;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    //如果外层的开始和结束的字符串相等的话，那么就去进行看内层的结果集是不是相同，如果都相同那就是说明是回文
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                //如果遍历完成，说明i -> j的值就是最大的回文串，当差值等于字符串的长度时跳出循环
                if (dp[i][j] && l + 1 > ans.length()) {
                    //i来控制开始下标，l表示从i -> j的距离值
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
