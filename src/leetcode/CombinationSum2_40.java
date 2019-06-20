package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 不可以重复使用数字
 * Created by wtwang on 2019/6/20.
 */
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        help(list,new ArrayList<>(),0,candidates,0,target);
        return list;
    }

    public void help(List<List<Integer>> list,List<Integer> curList,int curSum,int[] candidates,int curIndex,int target){
        if(curSum == target){
            list.add(new ArrayList<>(curList));
        }else if(curSum > target){
            return;
        }else{
            for(int i=curIndex;i<candidates.length;++i){
                //去除重复的数字
                if(i>curIndex && candidates[i] == candidates[i-1]){
                    continue;
                }
                curList.add(candidates[i]);
                //i变为i+1
                help(list,curList,curSum+candidates[i],candidates,i+1,target);
                curList.remove(curList.size()-1);
            }
        }
    }
}
