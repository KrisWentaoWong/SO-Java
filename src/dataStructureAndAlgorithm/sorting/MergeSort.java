package dataStructureAndAlgorithm.sorting;

/**
 * 归并排序
 * Created by wtwang on 2019/6/19.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] arr = {4,1,3,2,5,7,6};
        sort(arr);
    }

    public static void sort(int[] arr){
        int l = arr.length;
        int[] newarr = help(arr,0,l-1);
        new PrintArray().printArray(newarr);
    }

    public static int[] help(int[] arr,int start,int end){
        if(start > end){
            return new int[0];
        }else if(start == end){
            return new int[]{arr[start]};
        }
        int mid = (end - start) /2 + start;
        //递归排序前半部分和后半部分
        int[] first = help(arr,start,mid);
        int[] second = help(arr,mid+1,end);
        //再将已排序的前半部分和已排序的后半部分排序
        return helpSort(first,second);
    }

    public static int[] helpSort(int[] first,int[] second){
        int l1 = first.length,l2 = second.length;
        int[] res = new int[l1+l2];
        int i=0,j=0,k=0;
        while(i < l1 && j < l2){
            if(first[i] <= second[j]){
                res[k++] = first[i++];
            }else{
                res[k++] = second[j++];
            }
        }
        if(i < l1){
            for(int m=i;m<l1;++m){
                res[k++] = first[m];
            }
        }
        if(j < l2){
            for(int n=j;n<l2;++n){
                res[k++] = second[n];
            }
        }
        return res;
    }
}

