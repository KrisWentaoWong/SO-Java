package dataStructureAndAlgorithm.sorting;

/**
 * 快速排序
 * Created by wtwang on 2019/6/19.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5,7,6};
        sort(arr);
    }

    public static void sort(int[] arr){
        help(arr,0,arr.length-1);
        new PrintArray().printArray(arr);
    }

    public static void help(int[] arr,int front,int back){
        if(front >= back){
            return;
        }
        int pivot = arr[front];
        int start = front,end = back;
        while(start < end){
            //注意边界条件，需要先判断后面大的元素，这样和pivot交换的时候才正确，end指向的元素一定比pivot小
            while (start < end && arr[end] >= pivot){
                end--;
            }
            while (start < end && arr[start] <= pivot){
                start++;
            }
            if(arr[start] > pivot && arr[end] < pivot){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //将pivot放到正确的位置上
        arr[front] = arr[start];
        arr[start] = pivot;
        help(arr,front,start-1);
        help(arr,start+1,back);
    }


}
