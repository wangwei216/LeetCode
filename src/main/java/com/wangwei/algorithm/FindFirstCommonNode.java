package com.wangwei.algorithm;



import java.util.HashMap;

/**
 * @Description 输入两个链表，找出它们的第一个公共结点。
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/13 21:48
 */
public class FindFirstCommonNode {
    /**
     * 主要需要考虑两种情况：
     *  （一）两个链表都没有环的情况下
     *  （二）两个链表有环的情况下
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        ListNode entryNodeOfLoop1 = findFirstCommonNode.findEntryNodeOfLoop(pHead1);
        ListNode entryNodeOfLoop2 = findFirstCommonNode.findEntryNodeOfLoop(pHead2);
        //如果两个链表都无环的话，那就走无环链表想交问题
        if (entryNodeOfLoop1 == null && entryNodeOfLoop2 == null){
            noBothLoop(pHead1,pHead2);
        }
        //如果两个链表都有环的话，那么就走有环链表相交问题（但是不会存在一个有环一个无环还能相交的情况）
        if (entryNodeOfLoop1 != null && entryNodeOfLoop2 != null){
            bothLoop(pHead1,pHead2);
        }
        return pHead1;
    }


    /**
     * 这个是两个链表都有环，那么会出现三种情况：
     *  1. 两个链表都各自成环
     *  2. 两个链表最后一起共享同一个环
     *  3. 一个A链表有环，而且B链表和A链表相交的地方是在A链表的环上相交
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode bothLoop(ListNode pHead1, ListNode pHead2) {
        return pHead1;
    }


    /**
     * 如果两个链表都没环的话，那么先分别拿到每一个链表的长度和最后一个节点就够了
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode noBothLoop(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //通过遍历一遍获取到每个链表的长度和最后一个节点
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int n1 = 0;
        int n2 = 0;
        while (cur1.next != null){
            n1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n2++;
            cur2 = cur2.next;
        }
        //如果两个链表的最后节点的内存地址不相等的话，那么两者就不相交，相等的话就是Y字形
        if (cur1 != cur2){
            return null;
        }
        //这里主要的目的是为了确定那个链表的长度长，，然后把各自的链表头结点给循环链表
        if (n1 > n2){
            cur1 = pHead1;
        }else {
            cur1 = pHead2;
        }
        if (pHead1 == cur1){
            cur2 = pHead2;
        }else {
            cur2 = pHead1;
        }
        //找到两者从头结点到相交节点之间的距离绝对值,然后让长出来的那个链表先走到和另外一个短的链表一样的位置，
        int n = Math.abs(n1 - n2);
        while (n != 0 ){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    /**
     * 这个是判断链表是不是有环，如果有返回入环第一个节点
     * @param pHead
     * @return
     */
    public ListNode findEntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode tmp = pHead;
        HashMap map = new HashMap<ListNode, Integer>();
        while (tmp != null) {
            if (map.containsKey(tmp)) {

                return tmp;
            }
            map.put(tmp, tmp.val);
            tmp = tmp.next;

        }
        return tmp;
    }

    public static void main(String[] args) {

    }
}
