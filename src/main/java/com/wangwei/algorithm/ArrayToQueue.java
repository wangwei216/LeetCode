package com.wangwei.algorithm;

import sun.misc.Queue;

/**
 * @Description 用数组实现一个队列：
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/10 22:51
 */
public class ArrayToQueue {

    /**
     * 这个是栈内部类
     * 核心思想其实就是用双指针来进行
     * start 表示每次出队列的值，end 表示每次入队列的值，然后用size进行做边界的限定
     */
    public static class ArrayQueue{

        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        //初始化数组
        public ArrayQueue(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("初始化数组大小不能小于0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        //peek只是把队列中的值给弹出来
        public Integer peek(){
            if (size == 0){
                throw new IllegalArgumentException("队列为空！");
            }
            Integer result = arr[start++];
            return result;
        }
        //poll是不仅把值给弹出来，而且还要把这个位置的值给删了
        public Integer poll(){
            if (size == 0){
                throw new IllegalArgumentException("队列为空！");
            }
            size--;
            int tmp = start;
            start = start == arr.length-1 ? 0 : start+1;
            return arr[tmp];
        }
        //表示入队列
        public void push(int num){
            if (size == arr.length){
                throw new IllegalArgumentException("说明队列满了！");
            }
            size++;
            arr[end] = num;
            //当如果end已经到了栈底了，那就把end指针指向0位置,如果没有指向栈底的话，那么入栈之后end指针就需要继续走
            end = (end == arr.length-1) ? 0 : end+1;
        }


    }

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.push(111);
        arrayQueue.push(444);
        Integer num = arrayQueue.poll();
        arrayQueue.push(555);
        Integer num1 = arrayQueue.poll();
        System.out.println(num);
        System.out.println(num1);
        arrayQueue.push(999);
        Integer num3 = arrayQueue.poll();
        System.out.println(num3);
    }
}
