package com.wangwei.algorithm.LinkedList;

/**
 * @Description 删除倒数第K个节点
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/22 0:19
 */
public class PrintLastKNode {

    /**
     * 思路：
     *  1.先定义两个指针一个前指针，一个后指针
     *  2.然后先让前指针向前走k-1(从0开始)，然后后指针开始从头开始走，那么当前指针到头的时候和后指针相差的刚好第K个节点，也就是后指针位置
     */
    public static ListNode printLastKNode(ListNode head, int k){
        //如果链表头指针为空的情况
        if (head == null || k == 0){
            return null;
        }
        ListNode ahead = head;
        ListNode behind = null;
        for (int i=0; i<k-1; i++){
            //如果输入的以head为头结点的链表的结点总数少于k
            if (ahead.next != null){
                ahead = ahead.next;
            }else {
                return null;
            }
        }
        //然后把链表头结点的指针给后指针，他会继续遍历直到链表为空的时候
        behind = head;
        while (ahead.next != null){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        ListNode reslut = printLastKNode(head1, 6);
        System.out.println("倒数第K个节点为："+reslut.val);
    }
}

