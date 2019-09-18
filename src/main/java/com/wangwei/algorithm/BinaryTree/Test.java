package com.wangwei.algorithm.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description Test
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/18 13:19
 */
public class Test {


    public static void main(String[] args) {

        HashMap map = new HashMap();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int lenth = scanner.nextInt();
            System.out.println(lenth);
            Integer[] arr = new Integer[lenth];
            for (int i=0;i<lenth;i++){
              arr[i]  = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr));
        }


    }

}
