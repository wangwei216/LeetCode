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
    public static class ResultData{
        private Boolean isBlance;
        private int treeHeight;
        public ResultData (Boolean isBlance,int treeHeight){
            this.isBlance = isBlance;
            this.treeHeight = treeHeight;
        }
    }

    /**
     * 其实判断一整颗树是不是平衡的条件：
     *  1.左树是不是平衡
     *  2.右树是不是平衡
     *  3.左树高度
     *  4.右树高度
     * @param head
     * @return
     */
    public static Boolean isBlanceBinaryTree(Node head){
        return precess(head).isBlance ;
    }

    /**
     * 递归方法
     * @param head
     * @return
     */
    public static ResultData precess(Node head){
        if (head == null){
            return new ResultData(true ,0);
        }
        //先判断左树是不是平衡，如果左树不平衡直接返回false
        ResultData leftTree = precess(head.left);
        if (!leftTree.isBlance){
            return new ResultData(false ,0);
        }
        //判断右树
        ResultData rightTree = precess(head.right);
        if (!rightTree.isBlance){
            return new ResultData(false ,0);
        }
        //如果左右子树都平衡，那么还需要遵循平衡的概念(就是任意一个节点的左右子树的高度差不能超过1，否则就不是平衡二叉树)
        if (Math.abs(leftTree.treeHeight - rightTree.treeHeight) > 1){
            return new ResultData(false,0);
        }
        return new ResultData(true,Math.max(leftTree.treeHeight,rightTree.treeHeight) + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
//        head.left.left = new Node(4);
//        head.right.left = new Node(5);
//        head.right.right = new Node(6);
//        head.left.left.right = new Node(7);
        Boolean result = isBlanceBinaryTree(head);
        System.out.println("打印该二叉树是不是平衡二叉树："+result);
    }
}
