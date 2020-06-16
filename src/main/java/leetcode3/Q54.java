package leetcode3;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 判断你是否能够到达最后一个位置。
 示例 1:
 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

 */
public class Q54 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n<=1) return true;
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            if(max>=i){
                max = Math.max(max,i+nums[i]);
                if(max>=nums.length-1) return true;
            }

        }

        return false;
    }


}
