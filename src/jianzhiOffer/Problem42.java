package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * problem42:和为s的两个数字
 * description:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by wtwang on 2019/5/15.
 */
public class Problem42 {
    public static void main(String[] args){
        int[] array = {1,2,4,7,11,15};
        int sum = 15;
        FindNumbersWithSum(array,sum);
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<array.length;++i){
            //二分搜索查找sum-array[i]，如果不可以用库函数，则可以自己实现二分搜索
            if(Arrays.binarySearch(array,sum-array[i])>=0){
                res.add(array[i]);
                res.add(sum-array[i]);
                break;
            }
        }
        return res;
    }
}
