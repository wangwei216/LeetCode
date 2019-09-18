package com.wangwei.algorithm.String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description Main3
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/16 21:56
 */
public class Main3 {
    public static int getLen(Integer[] num){
        int ans = 1;
        Arrays.sort(num);
        for(int i = 0; i < num.length; ++i){
            for(int j = i + 1; j < num.length; ++j){
                int sum = 2;
                int d = num[j] - num[i];
                int now = num[j] + d;
                for(int k = j + 1; k < num.length; ++k){
                    if(num[k] == now){
                        sum += 1;
                        now += d;
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] arr = null;
        while (scanner.hasNext()){
            int lenth =  scanner.nextInt();
             arr = new Integer[lenth];
            for (int i=0;i<lenth ;i++){
                arr[i] = scanner.nextInt();
            }


        }
        int reslut = getLen(arr);
        System.out.println(reslut);

    }
}
