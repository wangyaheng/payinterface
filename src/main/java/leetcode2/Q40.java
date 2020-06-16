package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的每个数字在每个组合中只能使用一次。
 说明：
 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。 
 示例 1
 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 */
public class Q40 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(nums, target);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates,target ,0 ,new ArrayList<Integer>() ,result );
        return result;
    }

    public static void backtrace(int[] candidate,int target,int start,List<Integer> list,List<List<Integer>> result){
        if(target==0){
            // 找到目标值
            result.add(new ArrayList<>(list));
        }else if(target<0){
            return;//不符合条件
        }else{
            //回溯
            for (int  i= start; i < candidate.length; i++) {
                list.add(candidate[i]);
                backtrace(candidate,target-candidate[i] ,i+1 ,list ,result);
                list.remove(list.size()-1);
                while(i<candidate.length-1&&candidate[i+1]==candidate[i]){
                    i++;
                }
            }
        }
    }
}
