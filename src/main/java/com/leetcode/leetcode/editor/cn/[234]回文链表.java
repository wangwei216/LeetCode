//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 669 👎 0


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
     * 第一种方法就是快慢指针的方法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 首先处理特殊情况
        if (head == null || head.next == null) {
            return false;
        }
        // 第二步就是使用快慢指针找到链表中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 然后把后半部分链表进行反转
        ListNode newHead = revserList(slow);

        while (newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    // 反转一个链表
    public ListNode revserList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 先定义一个变量
        ListNode tail = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
