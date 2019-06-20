package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtwang on 2019/6/20.
 */
public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        //先将数组排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        help(list,curList,0,nums);
        return list;
    }

    public void help(List<List<Integer>> list,List<Integer> curList,int start,int[] nums){
        //这行是重点，将curList转换为new ArrayList再加入到结果中，因为Java中list是引用传递，会改变原来的list
        //包括空数组
        list.add(new ArrayList<>(curList));
        for(int i=start;i<nums.length;++i){
            //因为已经排过序，不需要再判断nums[i]是否已经出现在curList中
            curList.add(nums[i]);
            help(list,curList,i+1,nums);
            //将最后一个元素移除
            curList.remove(curList.size()-1);
        }
    }
}
