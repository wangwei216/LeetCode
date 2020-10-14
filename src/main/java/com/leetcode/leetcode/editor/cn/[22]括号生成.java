//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1314 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        Deque<String> path = new ArrayDeque<>();
        dfs("", n, res, 0, 0);
        return res;

    }

    /**
     * @param tmpString
     * @param n
     * @param path
     * @param left      代表左边用了几个括号
     * @param right     代表右边用了几个括号
     */
    public void dfs(String tmpStrPath, int n, List<String> res, int left, int right) {
        if (left == n && right == n) {
            res.add(tmpStrPath);
            return;
        }
        //如果右边的括号比左边的括号多，那就说明不成立
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(tmpStrPath + "(", n, res, left + 1, right);
        }
        if (right < n) {
            dfs(tmpStrPath + ")", n, res, left, right + 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
