package com.wangwei.algorithm.TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description GenerateParenthesisDemo
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * @Date 2020/9/10
 * @Author wangwei
 */
public class GenerateParenthesisDemo {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        backTrace("", 0, 0, n, result);
        return result;

    }

    /**
     * dfs
     * <p>
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param tmpStrResult 当前递归得到的结果【其实对应的是记录路径】其实走过的路径就是最后的结果集
     * @param left         左括号用了几个
     * @param right        右括号用了几个
     * @param n            表示传进来的括号个数
     * @param res
     */
    public void backTrace(String tmpStrResult, int left, int right, int n, List<String> res) {
        //首先是结束的触发条件
        if (left == n && right == n) {
            res.add(tmpStrResult);
            return;
        }
        if (left < right) {
            return;
        }
        //因为每个括号必须出现两次
        if (left < n) {
            backTrace(tmpStrResult + "(", left + 1, right, n, res);
        }

        if (right < n) {
            backTrace(tmpStrResult + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {
        int nums = 3;
        GenerateParenthesisDemo solution = new GenerateParenthesisDemo();
        List<String> lists = solution.generateParenthesis(nums);
        System.out.println(lists);
    }

}
