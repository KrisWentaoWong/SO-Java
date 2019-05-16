package problem;

/**
 * problem56:删除链表
 * description:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Created by wtwang on 2019/5/16.
 */
public class Problem56 {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node31 = new ListNode(1);
        ListNode node32 = new ListNode(1);
        ListNode node41 = new ListNode(1);
        ListNode node42 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node31;
        node31.next = node32;
        node32.next = node41;
        node41.next = node42;
        node42.next = node5;
        ListNode res = deleteDuplication(node1);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode newHead = pHead;
        ListNode next = pHead.next;
        //如果头部节点是重复节点，需要找到第一个不重复的节点
        while(newHead != null && next != null && newHead.val == next.val) {
            while (newHead != null && next != null && newHead.val == next.val){
                next = next.next;
            }
            newHead = next;
            if(next != null) {
                next = next.next;
            }
        }
        if(newHead == null){
            return null;
        }
        newHead.next = deleteDuplication(newHead.next);
        return newHead;

    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
