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
     * 1. 遍历整个链表，然后每次把遍历到的链表节点都放到一个Map集合中（也就是利用了Hash表的思想），
     * 2. 然后下次遍历到的节点先去Map中看存不存在，如果存在直接返回该节点，就是单链表入环的第一个节点
     * 3. 备注：其实map的key是节点对象的内存地址
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

    /**
     * 这个是不用hash表来实现这个找到单链表中的第一个入环节点的思路：
     * 1. 首先是用两个指针，一个快指针，一个慢指针，然后慢指针一次走一步，快指针一次走两步
     * 2. 当快指针和慢指针相遇的时候，然后块指针从头开始进行，并且此时快指针改变为一次走一步
     * 3. 当两者再次相遇的时候，就是链表第一个入环的节点
     *
     * 结论：这个是一个推理得到的结论，为什么第一次相遇的时候，把快指针从头开始变为一步一步的走，
     * 和慢指针相遇的节点就是我们想要的结果，这个方式，省去了使用Map的hash表的辅助空间复杂度
     */
    public ListNode findEntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //这里就是如果两者相遇的话，那么快指针就从头开始
            if (fast == slow) {
                fast = pHead;
                //只要两者没有再一次相遇那么两者就继续走，直到相遇就，且相遇的节点就是第一个入环节点
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }



}
