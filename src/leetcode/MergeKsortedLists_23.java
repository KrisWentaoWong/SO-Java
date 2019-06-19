package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wtwang on 2019/5/21.
 */
public class MergeKsortedLists_23 {
    public static void main(String[] args){
        ListNode[] lists = new ListNode[1];
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;
        lists[0] = node11;
        lists[1] = node21;
        lists[2] = node31;
        mergeKLists(lists);

    }

    /**
     * 用最小堆每次取出最小的元素，复杂度为nklog(k)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0){
            return null;
        }
        ListNode newHead = null,curP = null;
        ListNode[] cur = new ListNode[length];
        for(int i=0;i<length;++i){
            if(lists[i] != null){
                cur[i] = lists[i];
            }
        }
        int lastIndex = -1,curIndex = -1;
        //定义最小堆，同时保存元素值和链表的下标
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        while(curIndex == -1 || !pq.isEmpty()) {
            for (int i = 0; i < length; ++i) {
                /**
                 * 每次取出最小堆堆顶的元素，作为新链表的下一个节点。那么只需要再将取出元素的那个链表的下一个节点加入最小堆即可
                 */
                if (cur[i] != null && (lastIndex == -1 || i == lastIndex)) {
                    pq.offer(new int[]{cur[i].val,i});
                }
            }

            //记录当前链表下标
            if(pq.peek() != null){
                curIndex = pq.peek()[1];
                if(cur[curIndex] != null){
                    cur[curIndex] = cur[curIndex].next;
                    lastIndex = curIndex;
                }
            }
            //将堆顶元素加入到新链表的下一个节点，需要判断是否是第一个节点
            if (newHead == null) {
                if(pq.peek() != null) {
                    newHead = new ListNode(pq.peek()[0]);
                    curP = newHead;
                }else{
                    return null;
                }
            } else {
                if(pq.peek() != null) {
                    curP.next = new ListNode(pq.peek()[0]);
                    curP = curP.next;
                }else{
                    curP.next = null;
                }
            }
            pq.poll();
        }
        //处理只有一条链表或者最后只剩一条链表的情况，此时最小堆会为空
        while (curIndex != -1 && cur[curIndex] != null){
            curP.next = new ListNode(cur[curIndex].val);
            cur[curIndex] = cur[curIndex].next;
            curP = curP.next;
        }
        return newHead;

    }

    /**
     * 用二分法归并排序，牛逼！！！
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists){
        return partition(lists,0,lists.length-1);
    }

    public static ListNode partition(ListNode[] lists,int s,int e){
        if(s == e){
            return lists[s];
        }else if(s < e){
            int m = (s+e)/2;
            ListNode l1 = partition(lists,s,m);
            ListNode l2 = partition(lists,m+1,e);
            return merge(l1,l2);
        }else{
            return null;
        }
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
