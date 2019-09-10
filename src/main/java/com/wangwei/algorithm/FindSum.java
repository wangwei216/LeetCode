package com.wangwei.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: 给你一个整数，找出这个整数范围内的所有相邻的数之和为 这个整数的组数
 * 比如给你：5 ，【0,5】，【2，3】
 * @Date: 2019/9/9 15:49
 * @Version 1.0
 */
public class FindSum {

    public int findSum(int[] arrary){
        int count = 1;
        if (arrary.length == 0){
            return 0;
        }
        if (arrary.length == 1){
            return 1;
        }else {
            for (int i=0;i<arrary.length; i++){
                for (int j=i+1;j<arrary.length; j++){
                    if ((arrary[i]+arrary[j] == arrary[arrary.length-1]) && (j == i+1)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int sum =0;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num+1];
        for (int i=0; i<=num; i++){
            arr[i] = i;
        }
        FindSum test = new FindSum();
        if (arr.length == 1){
            return ;
        }else {
            sum = test.findSum(arr);
        }
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));
    }
}
