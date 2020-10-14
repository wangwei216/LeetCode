//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 371 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(res, list, s, 0);
        return res;
    }

    /**
     * @param res   返回的结果集
     * @param list  每一组合适的结果集
     * @param s     字符串
     * @param start 因为截取字符串的时候是左闭右开，所以需要截取循环i的下一个开区间
     */
    public void dfs(List<List<String>> res, List<String> list, String s, int start) {
        if (s.length() == start) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tmpStr = s.substring(start, i + 1);
            if (isPalin(tmpStr)) {
                //这一步是先把当然字符串的结果集保存起来
                list.add(tmpStr);
                dfs(res, list, s, i + 1);
                //把刚刚添加的结果集给删除掉，相当于回退
                list.remove(list.size() - 1);
            }
        }

    }

    /**
     * 判断是不是一个回文串，使用的思路就是两边向中心进行运行的方向
     *  1. 首先是因为回文串本身就是对称的，回文串肯定是对称的
     */
    public Boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
