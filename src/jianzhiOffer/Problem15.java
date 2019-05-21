package jianzhiOffer;

/**
 * problem15:反转链表
 * description:输入一个链表，反转链表后，输出新链表的表头。
 * Created by wtwang on 2019/5/13.
 */
public class Problem15 {
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReverseList(node);
    }
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //三个指针，curHead指向当前已反转部分的头节点，curTail指向当前已反转部分的尾节点，cur指向待处理的下一个节点
        ListNode curHead = head,curTail = head,cur = head.next;
        while(cur != null){
            curTail.next = cur.next;
            cur.next = curHead;
            ListNode temp = cur;
            cur = curTail.next;
            curHead = temp;
        }
        return curHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
