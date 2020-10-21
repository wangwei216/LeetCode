//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
     * 直接使用三个指针进行的
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 需要一个变量来保存当前遍历节点的下一个节点
            ListNode nxt = cur.next;
            // 然后需要进行反转，把原来的节点的下一个节点指向自己预留的头节点
            cur.next = pre;
            // 然后往前走，更新当前节点的前一个节点
            pre = cur;
            // 这里是进行更新当前节点
            cur = nxt;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
