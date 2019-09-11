package com.wangwei.algorithm;


/**
 * @Description 利用一个数组实现栈的操作
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/10 22:15
 */
public class ArrayToStack {

    /**
     * 核心的思想其实就是使用index下标来进行控制数组的入栈和出栈
     */
    public class ArrayStack {
        private int index;
        private Integer[] arr;

        public ArrayStack(int initSize) {
            if (initSize < arr.length) {
                throw new IllegalArgumentException("超出数组的长度了");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        //只是出栈，并没有删除栈的数据
        public Integer peek() {
            if (index == 0) {
                throw new IllegalArgumentException("栈中没有元素");
            }
            return arr[index - 1];
        }

        public void push(int num) {
            if (index == arr.length){
                throw new IllegalArgumentException("超出栈的长度了");
            }
            arr[index++] = num;
        }

        //如果出栈的时候，那就获取到出栈的指针指向的前一个位置的元素
        public Integer pop() {
            if (index == 0) {
                throw new IllegalArgumentException("栈中没有元素");
            }
            return  arr[--index];
        }
    }

    public static void main(String[] args) {


    }

}
