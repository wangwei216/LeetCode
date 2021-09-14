//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 429 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 直接使用暴力法，巧妙的点就是 char 类型的相减得到的就是 ACII 码的值也就是对应数字的值
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder("");
        while (m >= 0 || n >= 0 || carry != 0) {
            // 这里需要 >= 0 目的是为了如果字符串位数不够的话，需要进行补 0 的
            int x = m >= 0 ? num1.charAt(m) - '0' : 0;
            int y = n >= 0 ? num2.charAt(n) - '0' : 0;

            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            m--;
            n--;
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
