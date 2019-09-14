package com.wangwei.algorithm.LinkedList;

/**
 * @Description 在一个排序的链表中,删除链表中重复的节点 ：例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/14 15:02
 */
public class DeleteRepeatNode {

    /**
     * 删除重复节点链表的思路：
     *  1.
     *
     */

    public ListNode deleteDuplication1(ListNode pHead) {
        ListNode header = new ListNode(-1);
        header.next = pHead;
        ListNode pre = header;
        ListNode nHead = pHead;
        //这一步其实就是从头进行遍历链表的头结点
        while (nHead != null && nHead.next != null){
            if (nHead.val == nHead.next.val){
                //这里就是为了把全部 重复的都找到，然后把一直往后找，直到找到不重复的跳出
                while (nHead.next != null && nHead  .val == nHead.next.val){
                    nHead = nHead.next;
                }
                pre.next = nHead.next;
            }
            else {
                //这一步其实为了把添加的（-1）头结点跟我们要判断的链表头结点进行连上，
                //然后把pre节点走到Phead节点上,除此之外就是把中间所有相同的节点都给跳过去
                pre.next = nHead;
                pre = pre.next;
            }
            //每次无论当前节点值和后面一个节点值是不是相等，头结点都要往后面走一步
            nHead = nHead.next;
        }
        return header.next;
    }


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        //判断当前节点的值和下一个节点的值是不是相等
        if (pHead.val == pHead.next.val){
            ListNode pNode = pHead.next;
            //只要当前节点跟上一个节点的值相等，那就一直往后找，直到找到跟当前节点不同的节点
            while (pNode != null && pNode.next.val == pHead.val){
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }
        //如果当前节点不是重复的节点的话
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }




    public static void main(String[] args) {

        DeleteRepeatNode deleteRepeatNode = new DeleteRepeatNode();
        // 1->2->2->2->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = deleteRepeatNode.deleteDuplication1(head1);

        while (listNode != null){
            System.out.println(listNode.val+"--");
            listNode = listNode.next;
        }

    }

}
