package com.wangwei.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wangwei
 * @Date: 2019/9/9 9:39
 * @Version 1.0
 * 两个数组a，b中各取一个数配成一对（a，b）,输出a数组中元素<=B数组中(神策笔试题)
 * 输入第一个数组的长度，然后输入数组的元素，第二个一样
 */
public class TwoArraryCompare {


    public int compareSize(int[] arrA,int[] arrB){
    int resultCount = 0;
    if (arrA.length == arrB.length){
        for (int i=0;i<arrA.length;i++){
            if (arrA[i] <= arrB[i]){
                resultCount++;
            }
        }
    }
    if (arrA.length != arrB.length){
        int min = Math.min(arrA.length, arrB.length);
        for (int i=0;i<min;i++){
            if (arrA[i] <= arrB[i]){
                resultCount++;
            }
        }
    }
    return resultCount;
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoArraryCompare arraryCompare = new TwoArraryCompare();

        int sizeA = sc.nextInt();
        int[] arrA = new int[sizeA];


        int i =0;
        while (sc.hasNext()){
            arrA[i++] = sc.nextInt();
            if (i == arrA.length){
                break;
            }
        }

        i =0;
        int sizeB = sc.nextInt();
        int[] arrB = new int[sizeB];
        while (sc.hasNext()){
            arrB[i++] = sc.nextInt();
            if (i == arrB.length){
                break;
            }
        }

        System.out.println("打印数组A"+Arrays.toString(arrA)+"-----打印数组B："+Arrays.toString(arrB));
        int result = arraryCompare.compareSize(arrA, arrB);
        System.out.println(result);

    }

}
