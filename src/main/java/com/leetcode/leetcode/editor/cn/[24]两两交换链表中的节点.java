//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 908 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 第一种方式迭代的方法：核心思路其实就是构建一个双指针，两者同时移动然后改变指针方向，同时还需要构建dummpy指针，和一个遍历的变量
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = dummy;
        // 然后就是遍历循环，结束的条件就是控制 tmp 变量，因为需要保证两个指针同时移动，就必须两个指针都得存在
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            // 然后就是因为需要进行指针的移动，先动2节点
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 然后最后是需要移动变量指针
            tmp = node1;

        }
        return dummy.next;
    }

    /**
     * 第二种递归的方式
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // A -> B -> C -> D
        // B -> A -> C -> D
        // B -> A -> D -> C
        // 先定义一个新的变量指向本次要返回的头节点
        ListNode nextHeader = head.next;
        ListNode rest = head.next.next;
        // 把A 放到 B 的后面
        nextHeader.next = head;
        // 这一步其实把下一次递归的头节点是 C ,连接到当前此次递归的末尾节点「其实也就是节点A」
        head.next = swapPairs(rest);
        return nextHeader;
    }












}
//leetcode submit region end(Prohibit modification and deletion)
