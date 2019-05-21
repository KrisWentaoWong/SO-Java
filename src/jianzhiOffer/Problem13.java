package jianzhiOffer;

/**
 * problem13:调整数组顺序使奇数位于偶数前面
 * description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by wtwang on 2019/5/13.
 */
public class Problem13 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6};
        reOrderArray(array);
    }

    public static void reOrderArray(int[] array) {
        int i=0;
        int oddIndex = 0;
        while(i<array.length){
            //如果是奇数，则将从oddIndex到当前位置后移一位，将当前位置的值放到oddIndex上
            if((array[i] & 1) == 1){
                int temp = array[i];
                for(int m=i;m>oddIndex;--m){
                    array[m] = array[m-1];
                }
                array[oddIndex] = temp;
                oddIndex++;
            }
            i++;
        }
    }
}
