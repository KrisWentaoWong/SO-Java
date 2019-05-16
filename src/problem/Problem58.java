package problem;

/**
 * problem58:对称的二叉树
 * description:请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by wtwang on 2019/5/16.
 */
public class Problem58 {
    boolean isSymmetrical(TreeNode pRoot) {
        return help(pRoot,pRoot);
    }

    boolean help(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }else if(root1.val != root2.val){
            return false;
        }else{
            return help(root1.left,root2.right) && help(root1.right,root2.left);
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
