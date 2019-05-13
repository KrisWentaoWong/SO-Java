package problem;

/**
 * problem17:树的子结构
 * description:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * Created by wtwang on 2019/5/13.
 */
public class Problem17 {
    public static void main(String[] args){
        //测试程序
        TreeNode root1 = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode root2 = new TreeNode(8);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(2);
        root2.left = node7;
        root2.right = node8;
        System.out.println(HasSubtree(root1,root2));
    }

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null){
            return false;
        }
        if(help(root1,root2)){
            return true;
        }else{
            if(root1 != null) {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }else{
                return false;
            }
        }
    }

    //判断root1是否从根结点包含root2
    public static boolean help(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }else if(root1 == null){
            return false;
        }else if(root1.val != root2.val){
            return false;
        }else{
            return help(root1.left,root2.left) && help(root1.right,root2.right);
        }
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
