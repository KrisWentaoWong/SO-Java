package problem;

/**
 * problem25:复杂链表的复制
 * description:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * Created by wtwang on 2019/5/14.
 */
public class Problem25 {
    //leetcode138已经通过，但是牛客网提交不通过
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode cur = pHead;
        //对于原链表的每个节点，都复制一份
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        //复制原链表的随机指针
        cur = pHead;
        while(cur != null){
            //将原链表当前节点的随机指针的下一个节点赋值给原链表下一个节点的随机指针
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }else{
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        //将新链表分离出来
        cur = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode newCur = newHead;
        while(newCur != null){
            cur.next = newCur.next;
            if(newCur.next != null) {
                newCur.next = cur.next;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;

    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
