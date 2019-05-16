package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * problem61:序列化二叉树
 * description:请实现两个函数，分别用来序列化和反序列化二叉树
 * Created by wtwang on 2019/5/16.
 */
public class Problem61 {
    public static void main(String[] args){
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);
        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        TreeNode root = null;
        System.out.println(Serialize(root));
        TreeNode treeNode = Deserialize(Serialize(root));
        System.out.println(1);
    }

    /**
     * 将二叉树序列化为字符串
     * 如果节点为空，则在字符串中存储null，如果节点不为空，则在字符串中存储节点的值
     * @param root
     * @return
     */
    static String Serialize(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            //flag表示一层节点中是否存在非空的节点，如果存在，则需要继续将这层序列化，如果不存在，则这层不需要序列化
            boolean flag = false;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    if(node.left != null) {
                        flag = true;
                    }
                    queue.offer(node.left);
                    if(node.right != null) {
                        flag = true;
                    }
                    queue.offer(node.right);
                }
            }
            if(!flag){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();++i){
            if(i != 0){
                sb.append(",");
            }
            if(list.get(i) != null){
                sb.append(list.get(i).val);
            }else{
                sb.append("null");
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串反序列化为二叉树
     * 字符串转化为字符串数组后，数组中的下标和左子节点右子节点有对应关系
     * @param str
     * @return
     */
    static TreeNode Deserialize(String str) {
        if("".equals(str)){
            return null;
        }
        String[] arr = str.split(",");
        if(arr.length == 1){
            return new TreeNode(Integer.parseInt(arr[0]));
        }else{
            TreeNode[] treeNodes = new TreeNode[arr.length];
            for(int i=0;i<arr.length;++i){
                if("null".equals(arr[i])){
                    treeNodes[i] = null;
                }else{
                    treeNodes[i] = new TreeNode(Integer.parseInt(arr[i]));
                }
            }
            for(int i=0;i*2+1<arr.length;++i){
                if(treeNodes[i] != null){
                    if(i*2+1 < arr.length){
                        treeNodes[i].left = treeNodes[i*2+1];
                    }
                    if(i*2+2 < arr.length){
                        treeNodes[i].right = treeNodes[i*2+2];
                    }
                }
            }
            return treeNodes[0];
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
