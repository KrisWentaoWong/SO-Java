package jianzhiOffer;

/**
 * problem16:合并两个排序的链表
 * description:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * Created by wtwang on 2019/5/13.
 */
public class Problem16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null,cur = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(head == null){
                    head = list1;
                    cur = head;
                    list1 = list1.next;
                }else{
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                }
            }else{
                if(head == null){
                    head = list2;
                    cur = head;
                    list2 = list2.next;
                }else{
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
        }
        //注意判断初始状态就有一个链表为空的情况
        if(list1 == null){
            if(head == null){
                head = list2;
            }else {
                cur.next = list2;
            }
        }
        if(list2 == null){
            if(head == null){
                head = list1;
            }else {
                cur.next = list1;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
