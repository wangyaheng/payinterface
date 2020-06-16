package leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 */
public class Q16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 1}, 0));
    }

    /**
     * 和上一题类似 排序加双指针法
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int temp = 0;
        int answer = 0;
        int tempabs = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            //if(nums[i]>target) return answer;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                //result = Math.min(result, nums[i]+nums[left]+nums[right]-target);
                temp = target - (nums[i] + nums[left] + nums[right]);
                tempabs = Math.abs(temp);
                if(tempabs<result){
                    result = tempabs;
                    answer = nums[i] + nums[left] + nums[right];
                }
                if(temp>=0) left++;
                else right--;
            }
            if(result==0) return answer;
        }
        return answer;
    }
}
