package jianzhiOffer;

/**
 * problem35:数组中的逆序对
 * description:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * Created by wtwang on 2019/5/15.
 */
public class Problem35 {
    public static void main(String[] args){
        Problem35 test = new Problem35();
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(test.InversePairs(array));
    }
    //本质上是归并排序，在排序的过程中计算逆序对的个数
    int count = 0;
    public int InversePairs(int [] array) {
        help(array,0,array.length-1);
        return count;
    }

    public int[] help(int[] nums,int start,int end){
        if(start > end){
            return new int[0];
        }else if(start == end){
            return new int[]{nums[start]};
        }
        int mid = (end-start)/2+start;
        int[] arr1 = help(nums,start,mid);
        int[] arr2 = help(nums,mid+1,end);
        return countSort(arr1,arr2);
    }

    public int[] countSort(int[] arr1,int[] arr2){
        int l1 = arr1.length,l2 = arr2.length;
        int[] res = new int[l1+l2];
        int i=0,j=0;
        int index = 0;
        while(i<l1 && j<l2){
            if(arr1[i] <= arr2[j]){
                res[index++] = arr1[i++];
            }else{
                res[index++] = arr2[j++];
                count = (count+l1-i)%1000000007;
            }
        }
        while(i<l1){
            res[index++] = arr1[i++];
        }
        while(j<l2){
            res[index++] = arr2[j++];
        }
        return res;
    }
}
