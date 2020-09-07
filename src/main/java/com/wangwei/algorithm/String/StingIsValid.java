package com.wangwei.algorithm.String;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description StingIsValid
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * @Date 2020/9/7
 * @Author wangwei
 */
public class StingIsValid {

    /**
     * 判断是不是有效括号
     *  1. 首先字符是奇数说明肯定是false
     *  2. 遍历每一个字符，如果等于左括号，就放一个右括号到栈中，因为前一半中第一个先进栈，但是最后一个栈中才在栈顶
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '('){
                stack.push(')');
            } else if (array[i] == '['){
                stack.push(']');
            } else if (array[i] == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || array[i] != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "()[]{}";
        StingIsValid stingIsValid = new StingIsValid();
        boolean valid = stingIsValid.isValid(test);
        System.out.println(valid);
    }

}
