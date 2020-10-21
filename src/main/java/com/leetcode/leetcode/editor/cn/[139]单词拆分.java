//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 716 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一种方式是使用回溯进行的，如果优化需要进行剪枝
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict,"");
    }

    // tmpStr表示当前生成的字符串
    public Boolean dfs(String s, List<String> wordDict, String tmpStr) {
        if (s.length() == tmpStr.length()){
            if (s.equals(tmpStr)){
                return true;
            } else {
                return false;
            }
        }
        if (tmpStr.length() > s.length()){
            return false;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if (dfs(s,wordDict,tmpStr+wordDict.get(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * 第二种就是利用动态规划
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        Boolean[] dp = new Boolean[];
        //base case


    }
}
//leetcode submit region end(Prohibit modification and deletion)
