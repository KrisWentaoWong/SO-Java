package leetcode;

/**
 * Created by wtwang on 2019/6/19.
 */
public class ConvertSortedListToBinarySearchTree_109 {
    public static void main(String[] args){
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        sortedListToBST(node1);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        int length = 0;
        //第一次遍历求出链表长度
        while(cur != null){
            cur = cur.next;
            length++;
        }
        int[] arr = new int[length];
        cur = head;
        int i=0;
        //第二次遍历将链表转换为数组
        while(cur != null){
            arr[i++] = cur.val;
            cur = cur.next;
        }
        return help(arr,0,length-1);
    }

    public static TreeNode help(int[] arr,int start,int end){
        if(start == end){
            return new TreeNode(arr[start]);
        }else if(start > end){
            return null;
        }else{
            TreeNode head = new TreeNode(arr[(end+start+1)/2]);
            //递归构造左右子树
            head.left = help(arr,start,(end+start+1)/2-1);
            head.right = help(arr,(end+start+1)/2+1,end);
            return head;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
