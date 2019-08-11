package com.demo.zuoshen_videocode.basic_class01;

import java.util.Arrays;

public class Code_03_HeapSort {

	/**
	*堆排序的总方法，里面包含了把数组变成堆的方法，和调整堆的方法
	*	1. 首先第一步需要把一个数组给变成一个堆（但是此时的堆并不是有序的大根堆或者小根堆的结构）
	*	2. 然后需要把堆结构给进行调整成有序的堆结构
	*	3. 然后依次把最顶堆的位置和最后位置的数进行交换，并且每次交换前先要对堆的size减一
	*	（这里减一的目的就是把已进行排好的给放到数组中，下次就不用在进行参与堆调整的操作了），
	*      进行变换（这里交换的目的就是为了拿到此次堆调整中的最大值）
	**/
	public static void heapSort(int[] arr) {
		//1.先进行对数组为空的情况和数组只有一个数的时候进行判断
		if(arr.length < 2 || arr == null){
			return;
		}
		//2.就是把数组的数一个一个插入到堆中
		for (int i =0 ;i< arr.length; i++){
			heapInsert(arr,i);
		}
		//3.数组中的第一个位置的数跟堆中最后一个数进行交换（因为数组的最后一位的下标是size-1）
		int size =  arr.length;
		swap(arr,0,--size);
		//这里就是遍历这个数组，当整个数组的都被排好序之后也就是size=0 的时候结束
		while (size > 0){
		//4.然后每次都进行一个调整堆的方法，使其满足堆的结构和性质
			heapify(arr,0,size);
		//5.然后就开始交换并且，把交换之后的最大的数给放到数组中了，就不会参与下一次的堆调整的操作了
			swap(arr,0,--size);
		}

	}
	//这个就是把数组中下标所在位置的数据插入到堆中
	public static void heapInsert(int[] arr,int i){

	}


	public static void heapify(int[] arr,int index, int size){

	}


	/*public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			//1.就是把数组变成一个堆
			heapInsert(arr, i);
		}
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			//这一步其实就是在进行调整堆的顺序
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	//这个是调整堆的方法，只要当前堆不满足堆的基本性质就进行调整
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}*/

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
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

	// for test
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

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 5;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
