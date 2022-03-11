package com.wangwei.algorithm.LinkedList;

import java.util.Stack;

/**
 * @Description 判断一个链表是不是回文结构
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/19 13:50
 */
public class IsPalindromeList {

    /**
     * 判断一个链表是不是回文结构，其实可以有三种实现方式：
     *     1. 直接遍历把所有的链表节点都压到栈里，然后从和出栈的元素进行对比
     *采用  2. 使用双指针，找到中点元素，然后把中点之后的进行入栈，在从头开始和入栈之后的进行对比
     *     3. 找到中间节点，然后把后面的进行逆序翻转，然后从头结点遍历和从尾节点进行遍历对比，直到中点
     */
    public static Boolean isPalindromeList(ListNode head){
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        //当跳出这个循环的 时候，说明就找到的中点就是Slow指针,前一个条件是为了判断链表过短的情况
        while (fast.next != null &&  fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //然后把中点之后的所有的元素入栈
        Stack<ListNode> stack = new Stack();
        while (slow != null){
            System.out.println("打印："+slow.val);
            stack.push(slow);
            slow = slow.next;
        }
        //当栈不为空的时候，就和头节点进行比对，如果相等就继续
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            if (pop.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }


    /**
     * 第一种方法是基于简单原地直接迭代进行反转链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        // 这里直接就按照简单反转链表的逻辑，构建当前节点，和一个 pre 头节点
        ListNode cur = node.next;
        ListNode pre = null;
        ListNode tmp = null;

        for (int i = m; i <= n; i++) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 1->2->3->4->5
        // 1->4->3->2->5
        // 因为第一次的循环其实已经先走了m步，也就是需要把不需要反转的那一部分的第一个节点 也就是把 5 挂到 2的后面
        node.next.next = cur;
        // 这一步其实是把反转链表部分的最后一个点 4 挂到 1 的后面
        node.next = pre;
        return dummy.next;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(6);
//        head1.next.next.next.next.next.next = new ListNode(2);
//        head1.next.next.next.next.next.next.next = new ListNode(1);

        ListNode result = reverseBetween(head1, 2, 4);
        while (result != null) {
           System.out.print(result.val + "->");
           result = result.next;
       }
        System.out.println("该链表是不是回文结构："+result);
    }

}
