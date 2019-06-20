package dataStructureAndAlgorithm.sorting;

/**
 * 冒泡排序
 * Created by wtwang on 2019/6/19.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5};
        sort(arr);
    }
    public static void sort(int[] arr){
        int l = arr.length;
        //外层循环表示循环的次数，因为冒泡排序每次遍历的结果是将最大的元素移到最后，所以需要将l次循环
        for(int i=0;i<l;++i){
            //每次比较相邻的两个元素，将大的元素交换到后面
            //对于未排序的部分，两两比较大小。l-1-i是因为第i次循环之后，最后已经有i个元素排好序，不需要再比较这些元素
            for(int j=0;j<l-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        new PrintArray().printArray(arr);
    }
}
