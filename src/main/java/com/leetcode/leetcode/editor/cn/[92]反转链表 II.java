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
     * 第一种方法是递归进行的
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转链表的前N个节点
     *
     * @param head
     * @param n
     * @return
     */
    ListNode reverseN(ListNode head, int n) {
        // 这个变量是用来保存找到头节点之后的 第n+1个节点
        ListNode nextNode = null;
        if (n == 1) {
            nextNode = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        //
        head.next.next = head;
        // 这个是反转之后的头节点和，其实就是反转的尾节点和原来的第n+1个节点连起来
        head.next = nextNode;
        return newHead;
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
