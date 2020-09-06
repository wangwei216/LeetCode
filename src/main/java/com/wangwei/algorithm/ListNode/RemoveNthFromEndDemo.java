package com.wangwei.algorithm.ListNode;



/**
 * @Description RemoveNthFromEndDemo
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Date 2020/9/3
 * @Author wangwei
 */
public class RemoveNthFromEndDemo {

    /**
     * 思路：
     *  1. 首先是如果要删除倒数第n个节点，需要先想到构造一个前置节点，然后从前置节点开始运行双指针
     *  2. 先让end节点先走n步，因为你要删除倒数第n个节点，所以必须要让end节点停在要删除的节点的前面位置
     *  3. 然后end节点和start节点同时走，当走到末尾的时候停下来
     *  4. 直接把要删除的那个给删除掉
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先在链表头部构造一个节点
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode start = pre;
        ListNode end = pre;

        while (n != 0){
            start = start.next;
            n--;
        }
        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;

        return pre.next;
    }

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
