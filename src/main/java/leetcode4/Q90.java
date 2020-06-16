package leetcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 说明：解集不能包含重复的子集。
 示例:
 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 */
public class Q90 {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);// 如果不排序的话就很难判断是否需要跳过当前的数
        backTrace(result,new ArrayList<Integer>() ,0 ,nums);
       // System.out.println(result);
        return result;
    }

    public static void backTrace(List<List<Integer>> result,List<Integer> list,int start,int[] nums){
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backTrace(result, list, i+1,nums );
            list.remove(list.size()-1);
        }
    }
}
