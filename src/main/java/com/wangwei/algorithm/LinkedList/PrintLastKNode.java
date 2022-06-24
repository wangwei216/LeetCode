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

    public static void reorderList(ListNode head) {
        dfs(head, head);
    }
    // 其实两个都是头节点，但是这个tail节点其实是递归到结尾时要返回到尾部节点，在最深后一层递归出来的时候就是 tail 节点
    public static ListNode dfs(ListNode head, ListNode tail) {
        if (tail == null) {
            return head;
        }
        ListNode returnTailNode = dfs(head, tail.next);
        // 到这里的时候，其实tail表示的头节点已经遍历到尾部了，表示源链表的最后一个非NULL节点
        if (returnTailNode == null) {
            return null;
        }

        // 如果returnNode或returnNode的后继等于tail，说明完成，注意tail即为尾节点，next需要set null
        if (returnTailNode == tail || returnTailNode.next == tail) {
            tail.next = null;
            return null;
        }

        // 将尾部遍历节点指向对应的头部遍历节点的next，正向节点指向尾部遍历节点
        tail.next = returnTailNode.next;
        returnTailNode.next = tail;
        return tail.next;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(6);
        reorderList(head1);


    }
}

