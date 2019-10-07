package com.wangwei.algorithm.String;

/**
 * @Description 打印字符串所有的子序列（不是子串，子串是都是字符串的子集，必须连续，子序列不需要连续）
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/10/7 17:37
 */
public class PrintAllSubsequence {

    public static void printAllSub(char[] str,int i,String result){
        //这个是Base case 也就是条件的终止
        if (str.length == i){
            System.out.println(result);
            return;
        }
        //这里是进行做决策的，表示不要当前的字符
        printAllSub(str,i+1,result);
        //这个表示要拼接上当前的字符，然后继续往后走
        printAllSub(str,i+1,result+String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSub(str.toCharArray(),0,"");
    }
}
