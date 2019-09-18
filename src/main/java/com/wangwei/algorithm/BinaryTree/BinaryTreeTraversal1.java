package com.wangwei.algorithm.BinaryTree;

/**
 * @Description 递归遍历二叉树三种方式
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/14 20:44
 */
public class BinaryTreeTraversal1 {


    /**
     * 先序遍历二叉树：先根->左->右
     *
     */
    public void preOrderPrint(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value + "->");
        preOrderPrint(head.left);
        preOrderPrint(head.right);
    }

    /**
     * 中序遍历二叉树：先左->根->右
     * @param head
     */
    public void inOrderPrint(Node head){
        if (head == null){
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + "->");
        inOrderPrint(head.right);
    }

    /**
     * 后序遍历二叉树：先左->右->根
     * @param head
     */
    public void posOrderPrint(Node head){
        if (head == null){
            return;
        }
        posOrderPrint(head.left);
        posOrderPrint(head.right);
        System.out.print(head.value + "->");
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(8);
//        head.right.left.left = new Node(8);
//        head.right.right = new Node(9);
//        head.right.right.left = new Node(10);
//        head.right.right.right = new Node(11);
        BinaryTreeTraversal1 binaryTreeTraversal1 = new BinaryTreeTraversal1();
//        binaryTreeTraversal1.preOrderPrint(head);
//        binaryTreeTraversal1.inOrderPrint(head);
        binaryTreeTraversal1.posOrderPrint(head);

    }

}
