package dataStructureAndAlgorithm.algorithm.sorting;

/**
 * 将数组输出的工具类
 * Created by wtwang on 2019/6/20.
 */
public class PrintArray {
    public void printArray(int[] arr){
        int l = arr.length;
        for(int i=0;i<l;++i){
            System.out.print(arr[i] + " ");
        }
    }
}
