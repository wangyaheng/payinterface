package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 答案中不可以包含重复的四元组
 [-1,-5,-5,-3,2,5,0,4]
 -7

 */
public class Q18 {

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7);
        System.out.println(lists);

    }
    /**
     * 两层循环+双指针法
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4) return result;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-3;i++){
            // 第一层循环
            //if(nums[i]>target) break;
            if(i>=1&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                // 第二层循环
                int m = j+1;
                int n = nums.length-1;
                while(m<n){
                    // 双指针法
                    if(target==nums[i]+nums[j]+nums[m]+nums[n]){
                        // 符合条件
                        result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;
                        n--;
                        while(m<n&&nums[m-1]==nums[m]){
                            m++;
                        }
                        while(m<n&&nums[n+1]==nums[n]){
                            n--;
                        }

                    }else if(target>nums[i]+nums[j]+nums[m]+nums[n]){
                        m++;
                    }else{
                        n--;
                    }

                }
            }

        }
        return result;
    }
}
