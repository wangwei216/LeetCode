package com.wangwei.algorithm.BinaryTree;

/**
 * @Description 判断一个二叉树是不是平衡二叉树
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/19 17:32
 */
public class IsBlanceBinaryTree {

    /**
     * 思路：使用递归的套路
     *   1.需要先进行把全部递归的情况列出来，然后不用去管具体怎么递归，只需要宏观的去看就够了
     *   2.
     *
     */


    public class ResultData{
        private Boolean isBlance;
        private int treeHeight;
        public ResultData (Boolean isBlance,int treeHeight){
            this.isBlance = isBlance;
            this.treeHeight = treeHeight;
        }
    }
}
