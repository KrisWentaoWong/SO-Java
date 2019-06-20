package dataStructureAndAlgorithm.sorting;

/**
 * 选择排序
 * Created by wtwang on 2019/6/19.
 */
public class SelectSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5};
        sort(arr);
    }

    public static void sort(int[] arr){
        int l = arr.length;
        for(int i=0;i<l;++i){
            int min = arr[i];
            int min_index = i;
            for(int j=i+1;j<l;++j){
                if(arr[j] < min){
                    min = arr[j];
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        new PrintArray().printArray(arr);
    }
}
