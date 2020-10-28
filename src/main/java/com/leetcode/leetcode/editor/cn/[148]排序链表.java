//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 791 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 第一种方法是使用快排进行排序达到O（nlogn），但是快排的效率比较低
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    // 进行快排
    public void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            // 先进行第一次交换，然后确定中间的一个值进行归位
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    // 这里采用递归进行
    public ListNode partion(ListNode head, ListNode end) {
        ListNode fast = head.next;
        ListNode slow = head;
        // 进行遍历，以第一个值作为基准进行遍历
        while (fast != end) {
            // 把快指针和慢指针，这里其实就是类似从右向左找到比基准值小的
            if (fast.val < head.val) {
                // 只要是快指针比基准值小，就需要进行交换，并且更新慢指针
                slow = slow.next;

                int tmp = fast.val;
                fast.val = slow.val;
                slow.val = tmp;
            }
            // 无论是快指针的值是不是大于第一个基准值，快指针都要往后走
            fast = fast.next;
        }

        //这里其实就是第一次的交换完成了，然后进行第二轮的交换
        if (slow != head) {
            int tmp = head.val;
            head.val = slow.val;
            slow.val = tmp;
        }
        return slow;
    }

    /**
     * 第二种方法就是使用归并排序，时间复杂度也是O(nlogn)
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        /*
        分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
        我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
        找到中点 slow 后，执行 slow.next = None 将链表切断。
        递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
        cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
        合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
        双指针法合并，建立辅助ListNode h 作为头部。
        设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
        返回辅助ListNode h 作为头部的下个节点 h.next。
        时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
         */

        // 0. 创建一个返回头节点的链表头
        ListNode h = new ListNode(0);
        ListNode res = h;

        // 1. 递归结束条件
        if (head == null || head.next == null){
            return head;
        }
        // 2. 通过快指针一次走2步，慢指针一次走1步，来找到中点位置
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 3. 需要把中点的后面那个置为null切断，然后进行把每一个都切成最小不可切分的步骤
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 4. 这里其实就是递归的时候最底层的两个值的交换
        while (left != null && right != null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            // 因为每次都把俩值依次把值放到h后面，所以要不断把head的指针往后走保证把每一段的都拼上
            h = h.next;
        }
        // 这里是最后左右指针两段的拼接
        h.next = left != null ? left : right;
        return res.next;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
