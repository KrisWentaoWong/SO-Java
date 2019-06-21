package dataStructureAndAlgorithm.algorithm.sorting;

import dataStructureAndAlgorithm.dataStructure.heap.Heap;

import java.util.PriorityQueue;

/**
 * 堆排序
 * Created by wtwang on 2019/6/19.
 */
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5,7,6};
        sort(arr);
    }

    public static void sort(int[] arr){
        //用priorityQueue构造最小堆，如果需要最大堆可以实现Comparator接口重写compare方法
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int l = arr.length;
//        for(int i=0;i<l;++i){
//            pq.add(arr[i]);
//        }
//        int i=0;
//        while(!pq.isEmpty()){
//            arr[i++] = pq.poll();
//        }
//        new PrintArray().printArray(arr);

        //用自己写的Heap
        Integer[] iarr = new Integer[arr.length];
        for(int i=0;i<iarr.length;++i){
            iarr[i] = arr[i];
        }
        Heap<Integer> heap = new Heap<>(iarr);
        while(heap.getSize() != 0){
            System.out.print(heap.remove()+" ");
        }
    }
}
