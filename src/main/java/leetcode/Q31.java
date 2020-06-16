package leetcode;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 必须原地修改，只允许使用额外常数空间。
 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 *
 *
 */
public class Q31 {

    public static void main(String[] args) {
        int[] ints = {1,5,1};
        nextPermutation(ints);
        System.out.println(ints);

    }

    public static void nextPermutation(int[] nums) {
        for(int i = nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                // 找到需要交换顺序的下标，交换
                int j = nums.length-1;
                while(nums[j]<=nums[i-1]&&j>0){
                    j--;
                }
                swap(nums,i-1 ,j>=nums.length-1?nums.length-1:j);

                // 对i以及后面的数字进行排序
                reverse(nums,i);
                return;
            }
        }
        // 已经是最大顺序 ,需要按照最小顺序排序

        for(int i = 0;i<nums.length/2;i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }

    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }





}
