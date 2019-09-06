/**
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
package com.wangwei.jianzhi_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @FileName: Offer06.java
 * @Description: Offer06.java类说明
 * @Author: wangwei
 * @Date: 2019/6/23 14:04
 */
public class Offer06 {


    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 思路一：这个是用栈实现打印的实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //这一步是进行压栈把链表中的数据进行压栈
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.add(listNode.val);
           listNode =  listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        //当栈不为空的时候进来，否则跳出循环
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }


    /**
     * 思路二：用链表的头插法进行实现链表逆序的打印
     */

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;

    }


}
