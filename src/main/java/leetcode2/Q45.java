package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 示例:
 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 */
public class Q45 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2,2,6,3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrace(nums,result ,0  ,list );
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            min = Math.min(min,result.get(i).size());
        }
        return min;
    }

    public static void backTrace(int[] nums, List<List<Integer>> result,int start,List<Integer> list){
        if(start==nums.length-1){
            // 符合条件
            result.add(new ArrayList<>(list));
        }else if(start>nums.length-1){
            // 跳出数组
            return;
        }else{
            int step = nums[start];
            for (int i = 0; i < step; i++) {
                list.add(start);
                backTrace(nums,result ,start+i+1 ,list );
                list.remove(list.size()-1);
            }

        }
    }
}
