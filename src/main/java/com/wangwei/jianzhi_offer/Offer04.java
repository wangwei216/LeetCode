/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.jianzhi_offer;

/**
 * @FileName: Offer04.java
 * @Description: Offer04.java类说明
 * @Author: admin
 * @Date: 2019/6/22 20:23
 */
public class Offer04 {


    /**
     *  二维数组中的查找问题思路：
     *  1. 首先你得知道这个二维数组是有序的，并且一个数的下面的都比他大，左边的都比他小
     *  2. 需要先考虑到跳出循环的临界条件
     *
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     *
     */
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        //1.首先是先从二维数组的右上角开始遍历
        int row = array.length;
        int cols = array[0].length;//这个就相当于是一个列的长度
        int i = 0,  j = cols - 1; //意思是先从右上角开始遍历
        //跳出循环的条件是大于行的长度，列的长度是小于0
        while(i <= row-1  && j >= 0){
            if(target == array[i][j]){
                return true;
            }else if( target > array[i][j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

}
