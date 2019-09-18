package com.wangwei.algorithm.String;

import java.util.Arrays;

/**
 * @Description Main4
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/16 22:03
 */
public class Main4 {

    public static int calApLength(int[] intAr){
        if (intAr==null){
            return 0;//返回空的情况
        }
        Arrays.sort(intAr);
        int maxlen=intAr[intAr.length-1]-intAr[0];
        int ans=1;
        if (maxlen==0){
            return intAr.length;
        }
        //dp[i][diff]的意思是intAr[0]到intAr[i],等差为diff的等差长度
        // 有diff=intAr[i]-intAr[j],j<i
        // dp[i][diff]=dp[j][diff]=1

        int[][] dp=new int[intAr.length][maxlen+1];
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j < maxlen+1; j++) {
                dp[i][j]=1;
            }
        }
        for (int i = 1; i <intAr.length ; i++) {
            for (int j = i-1; j >=0; j--) {
                int diff=intAr[i]-intAr[j];//算出i和j之间的等差
                dp[i][diff]=dp[j][diff]+1;//当前
                ans=Math.max(ans,dp[i][diff]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
