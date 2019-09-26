package com.wangwei.algorithm.LinkedList;

/**
 * @Description 删除链表中的倒数第K个节点，并且返回头结点
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/24 16:10
 */
public class DeleteLastKNode {

    /**
     *  思路：
     *      1.首先是定义一个快指针一个慢指针
     *      2.然后快指针先跑传入的K个节点，然后慢指针这时候和快指针同时开始跑，当快指针到头的时候，此时的慢指针就是停留的倒数第K个位置上
     */
    public static ListNode deleteLastKNode(ListNode head, int k){
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i<k; i++){
            fast = fast.next;
        }
        //然后判断要删除的节点是不是第一个节点
        if (head == null){
            return head.next;
        }
        //然后同时让快指针和慢指针一步一步的跑
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //然后此时的慢指针的位置就是要删除节点的位置
        slow.next = slow.next.next;

       return head;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        ListNode head = deleteLastKNode(head1, 2);
        while (head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }

    }
}
