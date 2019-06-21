package dataStructureAndAlgorithm.algorithm.sorting;

/**
 * 插入排序
 * Created by wtwang on 2019/6/19.
 */
public class InsertSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5};
        sort(arr);
    }
    public static void sort(int[] arr){
        int l = arr.length;

        //j从0开始遍历的话需要再执行一个循环来复制
//        for(int i=0;i<l;++i){
//            for(int j=0;j<i;++j){
//                if(arr[i] < arr[j]){
//                    int temp = arr[i];
//                    for(int k=i;k>j;--k){
//                        arr[k] = arr[k-1];
//                    }
//                    arr[j] = temp;
//                }
//            }
//        }

        //j从i-1开始遍历可以边查找边复制
        for(int i=0;i<l;++i){
            //找到第一个比a[i]小的元素，在找到之前，将元素向后复制
            int temp = arr[i];
            int j=i-1;
            for(;j>=0 && arr[j] > temp;--j){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }

        new PrintArray().printArray(arr);
    }
}
