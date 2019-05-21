package jianzhiOffer;

/**
 * problem14:链表中倒数第k个节点
 * description:输入一个链表，输出该链表中倒数第k个结点。
 * Created by wtwang on 2019/5/13.
 */
public class Problem14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null){
            return null;
        }
        int length = 0;
        //建立两个指针，间隔为k，第一个先向后走k步
        ListNode first = head;
        for(int i=0;i<k;++i){
            if(first != null) {
                first = first.next;
                length++;
            }
        }
        //如果给定k值大于链表长度，返回空
        if(k > length){
            return null;
        }
        //两个指针同时向后，当第一个指针指向链表结尾时停止
        ListNode second = head;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


