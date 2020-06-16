package leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 说明：解集不能包含重复的子集。
 示例:
 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 */
public class Q78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            backTrace(result,0 , nums,i+1 ,new ArrayList<Integer>());
        }
        //System.out.println(result);
        return result;
    }

    public static void backTrace(List<List<Integer>> result, int start, int[] nums, int k, List<Integer> list){
        if(k==0){
            // 找到结果
           // System.out.println();
            result.add(new ArrayList<>(list));
        }else{
            for (int i = start; i <nums.length; i++) {
                list.add(nums[i]);
                backTrace(result,i+1 ,nums ,k-1 , list);
                list.remove(list.size()-1);
            }
        }
    }
}
