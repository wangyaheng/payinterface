package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的数字可以无限制重复被选取。
 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1:
 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]

 */
public class Q39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);// 排序
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrace(candidates,0 ,target ,list ,result );
        return result;
    }

    /**
     * 回溯法
     */
    public static void backtrace(int [] candidates,int start,int target,List<Integer> list, List<List<Integer>> result){
        if(target<0) return;
        else if(target==0){
            // 找到结果了 加入结果
            result.add(new ArrayList<>(list));
        }else {
            for (int i = start; i < candidates.length; i++) {
                // 进行回溯
                list.add(candidates[i]);
                backtrace(candidates,i,target-candidates[i] ,list ,result);
                // 关键一步 移除最后一个元素，进行回溯
                list.remove(list.size()-1);
            }

        }

    }


}
