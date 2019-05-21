package jianzhiOffer;

/**
 * problem39:平衡二叉树
 * description:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * Created by wtwang on 2019/5/15.
 */
public class Problem39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1){
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }else{
            return false;
        }
    }

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
