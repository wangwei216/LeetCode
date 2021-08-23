//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1448 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    /**
     * 双链表 + HashMap 实现一个LRU算法队列
     */
    private int capacity;
    private HashMap<Integer, ListNode> hashMap;
    private ListNode head;
    private ListNode tail;

    // 需要定一个内部类ListNode， 给一个构造ListNode节点的构造方法
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    // 这里是定义一个LRU对象的构造方法
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        // 构造的LRU维护着首位相连的双连表
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 删除双链表逻辑
     * @param listNode
     */
    private void removeNode(ListNode listNode) {
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
    }

    /**
     * 双链表的尾部添加的秘诀【箭头指向谁去找谁】
     * 1. 其实就是先找当前插入节点的前节点，箭头指向谁就去找箭头指向的那个节点，给当前要插入的目标节点
     * 2. 然后再去找前半部分的另一个箭头指向
     * @param node
     *
     */
    private void addNodeToLast(ListNode node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void moveNodeToLast(ListNode node){
        removeNode(node);
        addNodeToLast(node);
    }


    public int get(int key) {
        // 首先判断
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            // 把这个节点删除并放入到最后
            moveNodeToLast(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.val = value;
            moveNodeToLast(node);
            return;
        }
        // 如果插入的节点数达到了缓冲的最大值
        if (hashMap.size() == capacity) {
            hashMap.remove(head.next.key);
            removeNode(head.next);
        }
        // 如果要插入的节点值不存在，需要新构造一个节点
        ListNode newNode = new ListNode(key, value);
        hashMap.put(key, newNode);
        // 在获取节点和插入新节点的话都需要把该节点放到最后
        moveNodeToLast(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
