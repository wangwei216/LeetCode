//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2078 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 如果使用栈的数据结构进行配对的话
     *  1. 首先需要
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.isEmpty()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // 如果第一个就是右括号的话，栈中没有数据，直接false
            // 如果不是左括号，那就是右括号，就跟最近的一个栈顶的数字进行比较，如果不等的话，也是False
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        // 如果最终都全部遍历完，说明都是有效括号
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
