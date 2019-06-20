package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wtwang on 2019/6/20.
 */
public class Permutations2_47 {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        permuteUnique(nums);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //boolean[]数组表示第i个元素是否在排列中出现过
        help(list,new ArrayList<>(),nums,new boolean[nums.length]);
        return list;
    }

    public static void help(List<List<Integer>> list,List<Integer> curList,int[] nums,boolean[] used){
        if(curList.size() == nums.length){
            list.add(new ArrayList<>(curList));
        }else{
            for(int i=0;i<nums.length;++i){
                //如果第i个元素在排列中出现过，第i个元素和第i-1个元素相等且两个元素都未在排列中出现过
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                //否则将第i个元素加入到排列中
                used[i] = true;
                curList.add(nums[i]);
                help(list,curList,nums,used);
                //将第i个元素从排列中移除
                used[i] = false;
                curList.remove(curList.size()-1);
            }
        }
    }
}
