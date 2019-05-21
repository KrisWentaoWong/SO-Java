package jianzhiOffer;

/**
 * problem55:链表中环的入口节点
 * description:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * Created by wtwang on 2019/5/16.
 */
public class Problem55 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(EntryNodeOfLoop(head).val);
    }
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        /**
         * 设置快慢指针，快指针每次向后移动两步，慢指针每次向后移动一步
         * 如果有环，那么快慢指针会在环内相遇。
         * 假设链表头部到环入口节点的距离为a，从环入口到相遇节点的距离为b，设环的长度为c
         * 设慢指针在环内绕了n圈，那么慢指针一共走了a+nc+b步
         * 设快指针在环内绕了m圈，那么快指针一共走了a+mc+b步，可以得到2(a+nc+b)=a+mc+b，即a+b=(m-2n)c
         * 即从链表头部到相遇节点的距离a+b为环长度的整数倍
         * 将一个指针x从链表头部开始，另一个指针y从相遇的节点开始，当指针指向环开始节点时，x移动了a步，y也移动了a步
         * 因为y指针从相遇节点开始，相遇节点距离环开始节点b步，那么y指针移动a步刚好会到达环开始节点
         * 所以指针x和指针y会在环开始节点相遇
         */
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //找到环
            if(fast != slow){
                fast = fast.next.next;
                slow = slow.next;
            }else{
                fast = pHead;
                //找到环开始节点
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
