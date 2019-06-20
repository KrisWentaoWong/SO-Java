package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wtwang on 2019/6/20.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        help(list,new ArrayList<>(),nums);
        return list;
    }

    public void help(List<List<Integer>> list,List<Integer> curList,int[] nums){
        //只有当当前列表大小和数组大小相等时才是一个排列
        if(curList.size() == nums.length){
            list.add(new ArrayList<>(curList));
        }else{
            //遍历数组元素，如果不再当前列表中，则加入到当前列表中
            for(int i=0;i<nums.length;++i){
                if(!curList.contains(nums[i])){
                    curList.add(nums[i]);
                    help(list,curList,nums);
                    curList.remove(curList.size()-1);
                }
            }
        }
    }
}
