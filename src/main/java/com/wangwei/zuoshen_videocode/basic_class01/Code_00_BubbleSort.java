package com.wangwei.zuoshen_videocode.basic_class01;

import java.util.Arrays;

public class Code_00_BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	// for HungrySingleton
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for HungrySingleton
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		System.out.println("数组的长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 10) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for HungrySingleton
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for HungrySingleton
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for HungrySingleton
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for HungrySingleton
	public static void main(String[] args) {
		int testTime = 1;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			System.out.println("原来数组为："+Arrays.toString(arr1));
			int[] arr2 = copyArray(arr1);
			bubbleSort(arr1);
			System.out.println("排序后的数组为："+Arrays.toString(arr1));
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice,排序成功！" : "Fucking fucked，排序失败！");

	}

}
