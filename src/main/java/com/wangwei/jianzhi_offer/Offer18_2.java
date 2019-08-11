/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.jianzhi_offer;

/**
 * @FileName: Offer18_2.java
 * @Description: Offer18_2.java类说明
 * @Author: wangwei
 * @Date: 2019/6/23 17:09
 */
public class Offer18_2 {

    /**
     * @Author: wangwei
     * @Description: 删除链表中重复的结点
     * @Param: * @Param: null
     * @Date: 2019-06-23
     */
    public Offer06.ListNode deleteDuplication(Offer06.ListNode pHead) {
        /**
         * 首先的思路就是：
         *  1. 先对空的链表进行一个判断，如果传进来的链表为空的话就直接返回空连接头节点
         *  2. 首先拿到pHeader的下一个节点，然后用头结点的值和头结点的下一个节点的值进行判断
         *  3. 如果相同就把那个给删了
         *  4. 否则的话就直接递归头节点的下一个节点，作为
         */
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Offer06.ListNode next = pHead.next;
        if (next.val == pHead.val) {
            while (next != null && next.val == pHead.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }
}
