package com.wangwei.algorithm.BinaryTree;

import java.util.Stack;

/**
 * @Description 不使用递归来实现遍历二叉树的先序遍历、中序遍历、后续遍历
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/14 22:53
 */
public class BinaryTreeTraversal2 {


    public static void preOrderPrint(Node head){
        System.out.println("非递归实现二叉树的先序遍历！");
        if (head != null){
            Stack stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = (Node) stack.pop();
                System.out.println(head.value+" ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }

    }

    /**
     * 中序遍历的思路：
     *  1. 跳出的循环条件是只要head 不为空，或者栈不为空 就一直循环
     *  2. 如果是头不为空，那么就先把head节点压栈
     *  3. 否则其实是直接出栈，然后打印，指针向右移动
     * @param head
     */
    public static void inOrderPrint(Node head){
        System.out.println("非递归实现二叉树的中序遍历！");
        if (head != null){
            Stack stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = (Node) stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 后续遍历的思路：
     *   1.其实思路就是把之前先序遍历的打印不打印，然后放到一个辅助栈中，然后在打印
     * @param head
     */
    public static void posOrderPrint(Node head){
        System.out.println("非递归实现二叉树后续遍历！");
        if (head != null){
            Stack stack = new Stack<Node>();
            Stack<Node> printStack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = (Node) stack.pop();
                printStack.push(head);
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
            while (!printStack.isEmpty()){
                System.out.println(printStack.pop().value + " ");
            }
        }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        inOrderPrint(head);
    }

}
