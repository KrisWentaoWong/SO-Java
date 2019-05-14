package problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * problem29:最小的k个数
 * description:输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * Created by wtwang on 2019/5/14.
 */
public class Problem29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k){
            return list;
        }
        Arrays.sort(input);
        for(int i=0;i<k;++i){
            list.add(input[i]);
        }
        return list;
    }
}
