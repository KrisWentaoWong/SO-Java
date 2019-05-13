package problem;

/**
 * problem4:重建二叉树
 * description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Created by wtwang on 2019/5/10.
 */
public class Problem4 {
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode res = reConstructBinaryTree(pre,in);
        System.out.println(1);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return help(pre,0,pre.length-1,in,0,in.length-1);

    }

    public static TreeNode help(int[] pre,int pre_start,int pre_end,int[] in,int in_start,int in_end){
        if(pre_start == pre_end){
            return new TreeNode(pre[pre_start]);
        }
        if(pre_start > pre_end){
            return null;
        }
        //root为前序遍历第一个元素
        TreeNode root = new TreeNode(pre[pre_start]);
        int in_index = -1;
        //在中序遍历中找到root节点，在in数组中的下标为in_index，则左子树中有in_index-in_start个元素，右子树中有in_end-in_index个元素
        for(int i=in_start;i<=in_end;++i){
            if(in[i] == pre[pre_start]){
                in_index = i;
                break;
            }
        }
        root.left = help(pre,pre_start+1,pre_start+in_index-in_start,in,in_start,in_index-1);
        root.right = help(pre,pre_start+1+in_index-in_start,pre_end,in,in_index+1,in_end);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


