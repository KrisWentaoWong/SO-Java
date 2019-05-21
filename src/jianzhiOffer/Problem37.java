package jianzhiOffer;

/**
 * problem37:数字在排序数组中出现的次数
 * description:统计一个数字在排序数组中出现的次数。
 * Created by wtwang on 2019/5/15.
 */
public class Problem37 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,4,5};
        int k = 4;
        System.out.println(GetNumberOfK(array,k));
    }

    public static int GetNumberOfK(int [] array , int k) {
        if(array.length == 0){
            return 0;
        }
        //二分法找出k
        int low = 0,high = array.length-1;
        int mid = (high-low)/2+low;
        while(mid > low){
            if(array[mid] < k){
                low = mid + 1;
            }else if(array[mid] > k){
                high = mid - 1;
            }else{
                break;
            }
            mid = (high-low)/2+low;
        }
        //分别向前向后计算k出现的次数
        int count = 0;
        if(array[mid] == k){
            count++;
            int i=mid-1,j=mid+1;
            while (i>=0){
                if(array[i] == k){
                    count++;
                    i--;
                }else{
                    break;
                }
            }
            while (j<array.length){
                if(array[j] == k){
                    count++;
                    j++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
