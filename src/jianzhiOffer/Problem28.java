package jianzhiOffer;

/**
 * problem28:数组中出现次数超过一半的数字
 * description:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * Created by wtwang on 2019/5/14.
 */
public class Problem28 {
    public static void main(String[] args){
        int[] array = {2,2,2,2,2,1,3,4,5};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
        int count = 0;
        for(int i=0;i<array.length;++i){
            if(count == 0){
                num = array[i];
                count++;
            }else {
                if (num == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        //因为不一定存在这样的数，所以需要再遍历确认一遍
        count = 0;
        for(int i=0;i<array.length;++i){
            if(array[i] == num){
                count++;
            }
        }
        if(count > array.length/2) {
            return num;
        }else{
            return 0;
        }
    }
}
