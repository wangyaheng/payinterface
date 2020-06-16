package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 示例:
 输入: [1,1,2]
 输出:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 */
public class Q47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0) return result;
        Arrays.sort(nums);
        backtrace(nums,result ,new ArrayList<Integer>() ,nums.length ,new boolean[nums.length]);
        return result;
    }

    /**
     *
     * @param nums
     * @param result
     * @param list
     * @param n
     */
    public static void  backtrace(int nums[],List<List<Integer>> result,List<Integer> list,int n ,boolean[] use){
        if(n==0){
            result.add(new ArrayList<>(list));
            return;
        }else{
            for (int i = 0; i <nums.length; i++) {
                if(use[i]) continue;
                if(i>0&&nums[i]==nums[i-1]&&!use[i-1])continue;
                list.add(nums[i]);
                use[i] = true;
                backtrace(nums,result ,list ,n-1 ,use );
                use[i] = false;
                list.remove(list.size()-1);
            }
        }
    }



}
