package problem;

/**
 * problem36:两个链表的第一个公共节点
 * description:输入两个链表，找出它们的第一个公共结点。
 * Created by wtwang on 2019/5/15.
 */
public class Problem36 {
    /**
     * 假设在两个链表相交之前，链表1在与链表2各自的长度分别为a和b，相交部分的长度为c
     * 则分别遍历两个链表，到达尾部时交换指针，则两指针相等时分别经过了a+c+b和b+c+a个节点，且相遇的节点即为交点。
     * 牛客网中的测试用例未考虑到两个链表没有交点的情况，没有考虑到a和b相等即两个链表同时到达尾节点的情况。
     * 以下程序可以通过牛客网的测试用例，但还需要考虑到以上情况。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1,p2 = pHead2;
        while(p1 != p2){
            if(p1 != null) {
                p1 = p1.next;
            }else{
                p1 = pHead2;
            }
            if(p2 != null) {
                p2 = p2.next;
            }else{
                p2 = pHead1;
            }
        }
        return p1;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
