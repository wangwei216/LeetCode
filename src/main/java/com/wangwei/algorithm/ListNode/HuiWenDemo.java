package com.wangwei.algorithm.ListNode;

import com.wangwei.algorithm.LinkedList.ListNode;

/**
 * @Description HuiWenDemo
 * @Date 2021/10/27
 * @Author wangwei
 */
public class HuiWenDemo {

    MergeTwoListsDemo.ListNode tmpNode;

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->nu
        MergeTwoListsDemo.ListNode listNode = new MergeTwoListsDemo.ListNode(1, new MergeTwoListsDemo.ListNode(2, new MergeTwoListsDemo.ListNode(3, null)));
        HuiWenDemo huiWenDemo = new HuiWenDemo();
        boolean check = huiWenDemo.check(listNode);
        System.out.println(check);
    }

    public boolean check(MergeTwoListsDemo.ListNode head) {
        if (head == null) {
            return true;
        }
        // 这里的核心其实这个递归，因为是先执行的 check 递归方法，
        boolean isChecked = check(head.next);
        boolean res = isChecked && (head.val == tmpNode.val);
        tmpNode = tmpNode.next;
        return res;
    }

}
