package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * problem63:数据流中的中位数
 * description:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * Created by wtwang on 2019/5/16.
 */
public class Problem63 {
    public static void main(String[] args){
        int[] arr = {5,2,3,4,1,6,7,0,8};
        for(int i=0;i<arr.length;++i){
            Insert(arr[i]);
            System.out.println(GetMedian());
        }
    }

    /**
     * 插入的时候维护一个排序数组
     */
    static List<Integer> list = new ArrayList<>();
    public static void Insert(Integer num) {
        int index = 0;
        while(index < list.size()){
            if(list.get(index) <= num){
                index++;
            }else{
                break;
            }
        }
        if(index < list.size()) {
            list.add(num);
            for(int i=list.size()-1;i>=index+1;--i){
                list.set(i,list.get(i-1));
            }
            list.set(index,num);
        }else{
            list.add(num);
        }
    }

    public static Double GetMedian() {
        if((list.size() & 1) == 1){
            return Double.valueOf(list.get(list.size()/2));
        }else{
            return (Double.valueOf(list.get(list.size()/2-1)) + Double.valueOf(list.get(list.size()/2)))/2;
        }
    }
}
