package com.wangwei.zuoshen_videocode.basic_class01;

public class Code_08_NetherlandsFlag {


	/*
	* 荷兰国旗问题（就是给你一个数组，给你一个数，把数组中比这个数小的数全部放到这个数的左边，比这个数大的数都放到这个数组的右边）
	* 	1.首先需要虚拟出一部分less区域，一部分是more区域，只有中间的区域是你传过来的数组问题，还需要一个当前下标来进行遍历
	* 	2.然后分为三种情况（这里需要考虑一下循环边界）
	* 		1）如果数组的第一个数小于给定的这个数的话，那么就把数组中当前这个数跟less区域的下一个数进行交换，
	* 		   然后less区域加一，当前cur下标加一
	* 		2）如果数组的下一个下标大于cur下标所在的值的话，那么就把这个数跟more区域的前一个数（这个数是还没有排序的X）进行交换
	* 			然后因为X这个值还没有排序，所以当前cur下标不动，到这里如果这个X还是会有三种情况才会进行让cur继续往下走
	* 			但是最后这个结束的条件就是你最终的while循环的跳出条件
	* 		3）如果数组中cur当前指向的数和给定的那个num相等的话，那么这个数组的当前下标cur就加一，直接到下一个
	*
	*
	* */
	public static int[] partition(int[] arr, int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		while (cur < more){ //这里跳出循环的条件就是当less和more相遇的时候就需要跳出循环，就是根据第二步进行判断的
			if (arr[cur] < num){
				//说明进入到了less区域中（比这个num的值小的数放左边），需要和less区域的前一个数进行交换，然后cur继续往下一个走
				swap(arr,++less,cur++);
			}else if (arr[cur] > num){
				//说明进入到了more区域（其实也就是比这个num大放右边）
				swap(arr,--more,cur);
			}else {
				//说明当前的值跟给定的num相等，然后就不变
				cur++;
			}
		}
		//这里其实就相当于把数组给截取出来，因为less区域和more区域都是我们自己虚拟出来的区域，只是为了临时存放数据而已
		return new int[] {less+1,more-1};



	}

	// for HungrySingleton
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for HungrySingleton
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
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

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
