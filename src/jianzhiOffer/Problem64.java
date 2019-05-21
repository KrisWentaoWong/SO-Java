package jianzhiOffer;

import java.util.*;

/**
 * problem64:滑动窗口的最大值
 * description:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * Created by wtwang on 2019/5/16.
 */
public class Problem64 {
    public static void main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        maxInWindows(num,size);
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0){
            return res;
        }
        /**
         * 队列中的元素为原数组的下标，而不是数组中的值
         * 构造一个双向队列：
         * 1.如果当前下标的元素大于队列尾部下标的元素，则将队列尾部小于当前元素下标的全部出队列
         * 2.如果当前下标的元素小于队列尾部下标的元素，则将当前下标加入队列
         * 3.如果队列首部元素和当前下标的差值大于窗口的最大值，则将队列首部元素出队列
         */
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<num.length;++i){
            if(queue.isEmpty()){
                queue.offerLast(i);
            }else {
                if (num[i] >= num[queue.peekLast()]) {
                    while (!queue.isEmpty() && num[i] > num[queue.peekLast()]) {
                        queue.pollLast();
                    }
                    queue.offerLast(i);
                } else {
                    queue.offerLast(i);
                }
            }
            if(i-queue.peekFirst() == size){
                queue.pollFirst();
            }
            if(i >= size-1) {
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}
