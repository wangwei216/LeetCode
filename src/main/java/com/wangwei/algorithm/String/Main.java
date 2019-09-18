package com.wangwei.algorithm.String;

import java.util.Scanner;

/**
 * @Description 在字符串中找出连续最长的数字串
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/16 19:24
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            Main main = new Main();
            main.find(str);
        }
    }


    public void   find(String str){
        int len = str.length();
        int max = 0;
        int dp[] = new int[len];
        int flag =0;
        //动态规划边界
        if (str.charAt(0)>='0'&&str.charAt(0)<='9') {

            dp[0]=1;
        }
        for (int i = 1; i < len; i++) {
            if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=0;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]>max) {
                max = dp[i];
                flag = i;
            }
        }
        String temp = "";
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]==max) {
                temp+=str.substring(i-max+1,i+1);
            }
        }
        //打印结果
        System.out.println(max+"/"+temp);
    }

}
