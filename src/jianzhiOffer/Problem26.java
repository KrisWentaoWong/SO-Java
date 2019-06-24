package jianzhiOffer;

/**
 * problem26:二叉搜索树与双向链表
 * description:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by wtwang on 2019/5/14.
 */
public class Problem26 {
    public static void main(String[] args){
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node14 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        Convert(node10);
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode last = null;
        //函数返回后，last是整个链表最后一个节点
        last = help(pRootOfTree,last);
        TreeNode head = last;
        //寻找整个链表第一个节点
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    /**
     * 返回值表示链表的最后一个节点
     * 因为java不像C++可以传递指针，所以需要通过返回值来传递，也可以通过全局变量来传递
     * 一开始last为null，这个参数不是当前函数使用，而是为了将执行之后的结果传递回来
     * @param root
     * @param last
     */
    public static TreeNode help(TreeNode root,TreeNode last){
        if(root == null){
            return last;
        }
        //转换左子树，last返回后表示左链表的最后一个节点
        if(root.left != null){
            last = help(root.left,last);
        }
        //将左链表的最后一个节点和当前节点连接
        root.left = last;
        if(last != null){
            last.right = root;
        }
        //在转换右链表之前需要将上一个节点更新为当前节点
        last = root;
        //转换右链表
        if(root.right != null){
            last = help(root.right,last);
        }
        return last;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
