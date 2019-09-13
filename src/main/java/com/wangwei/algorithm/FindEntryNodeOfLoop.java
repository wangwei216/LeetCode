package com.wangwei.algorithm;

import java.util.HashMap;

/**
 * @Description 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @Version 1.0
 * @Author: wangwei
 * @Date: 2019/9/12 0:14
 */
public class FindEntryNodeOfLoop {

    /**
     * 思路就是：
     *  1. 遍历整个链表，然后每次把遍历到的链表节点都放到一个Map集合中（也就是利用了Hash表的思想），
     *  2. 然后下次遍历到的节点先去Map中看存不存在，如果存在直接返回该节点，就是单链表入环的第一个节点
     *  3. 备注：其实map的key是节点对象的内存地址
     *
     */
    public ListNode findEntryNodeOfLoop(ListNode pHead){
        if (pHead == null){
            return null;
        }
        ListNode tmp = pHead;
        HashMap map = new HashMap<ListNode,Integer>();
        while (tmp != null){
            if (map.containsKey(tmp)){

                return tmp;
            }
            map.put(tmp,tmp.val);
            tmp = tmp.next;

        }
        return tmp;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

}
