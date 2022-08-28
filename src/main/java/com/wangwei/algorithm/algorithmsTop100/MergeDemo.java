package com.wangwei.algorithm.algorithmsTop100;

import java.util.Arrays;

public class MergeDemo {


    public static void main(String[] args) {
        MergeDemo mergeDemo = new MergeDemo();
        int[] a= {5,8,1,6,46};
        mergeDemo.mergeSort(a, 0, a.length - 1);
        System.out.printf(Arrays.toString(a));

    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

    }
    // 这个是最核心的 合并流程，本质其实就是把 两个有序数组合并成一个数组
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int L = low;
        int R = mid + 1;
        int cur = 0;
        // 遍历两个数组，分别从数组头部开始，看谁小，就把谁放到临时数组中，知道某一个数组遍历完了，但是此时可能另外一个数组还有指
        while (L <= mid && R <= high) {
            if (arr[L] < arr[R]) {
                tmp[cur++] = arr[L++];
            } else {
                tmp[cur++] = arr[R++];
            }
        }
        // 分别看哪个数组还有值
        while (L <= mid) {
            tmp[cur++] = arr[L++];
        }
        // 这里会继续接着右边数组中剩下的值的下标位置，继续往下走
        while (R <= high) {
            tmp[cur++] = arr[R++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[j+ low] = tmp[j];
        }
    }


}
