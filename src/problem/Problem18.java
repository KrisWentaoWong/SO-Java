package problem;

/**
 * problem18:二叉树的镜像
 * description:操作给定的二叉树，将其变换为源二叉树的镜像。
 * Created by wtwang on 2019/5/13.
 */
public class Problem18 {
    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
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
