package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 可以重复使用数字
 * Created by wtwang on 2019/6/20.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                curList.add(candidates[i]);
                //因为可以重复使用数字，不需要将i变为i+1
                help(list,curList,curSum+candidates[i],candidates,i,target);
                curList.remove(curList.size()-1);
            }
        }
    }
}
