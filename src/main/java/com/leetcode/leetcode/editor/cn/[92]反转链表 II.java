//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 550 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import javax.swing.*;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 第一种方法是基于简单原地直接迭代进行反转链表
     *
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        // 这里直接就按照简单反转链表的逻辑，构建当前节点，和一个 pre 头节点
        ListNode cur = node.next;
        ListNode pre = null;
        ListNode tmp = null;

        for (int i = m; i <= n; i++) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 1->2->3->4->5
        // 1->4->3->2->5
        // 因为第一次的循环其实已经先走了m步，也就是需要把不需要反转的那一部分的第一个节点 也就是把 5 挂到 2的后面
        node.next.next = cur;
        // 这一步其实是把反转链表部分的最后一个点 4 挂到 1 的后面，而node.ndex 对应的就是第一次真实链表的头节点
        node.next = pre;
        return dummy.next;
    }

    /**
     * 第二种方法就是使用多加一个前置节点进行的反转
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //第一步先加上一个前置节点
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        // 找到最后开始反转的节点起点n
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        // 这里是为了反转m -> n 这一段的
        ListNode nextHead = node.next;
        ListNode pre = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        //将反转的起点的next指向next。
        node.next.next = next;
        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
        node.next = pre;
        return res.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
