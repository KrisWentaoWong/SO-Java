package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtwang on 2019/6/20.
 */
public class SubSet2_90 {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //先将数组排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        help(list,curList,0,nums);
        return list;
    }

    public static void help(List<List<Integer>> list,List<Integer> curList,int start,int[] nums){
        //这行是重点，将curList转换为new ArrayList再加入到结果中，因为Java中list是引用传递，会改变原来的list
        list.add(new ArrayList<>(curList));
        for(int i=start;i<nums.length;++i){
            //跳过重复的元素
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            curList.add(nums[i]);
            help(list,curList,i+1,nums);
            //将最后一个元素移除
            curList.remove(curList.size()-1);
        }
    }
}
