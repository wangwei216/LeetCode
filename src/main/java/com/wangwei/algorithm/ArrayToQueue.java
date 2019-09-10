package com.wangwei.algorithm;

/**
 * @Description ArrayToQueue
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/10 22:51
 */
public class ArrayToQueue {

    //这是一个数组构造的队列的内部类
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



    }

    public static void main(String[] args) {


    }
}
