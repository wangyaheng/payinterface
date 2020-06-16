package leetcode4;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 1225600 前半段有序
 5600122  后半段有序
 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 示例 1:
 输入: nums = [2,5,6,0,0,1,2], target = 3
 输出: true
 */
public class Q81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public static boolean search(int[] nums, int target) {
        int start= 0,end = nums.length-1;

        while(start<=end){
            int mid = (end+start)/2;
            if(nums[mid]==target){
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }

            if(nums[start]<=nums[mid]){
                // 前半段升序
                if(nums[start]<=target&&nums[mid]>target){
                    // 在前半段
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                // 后半段有序
                if(nums[mid]<=target&&nums[nums.length-1]>=target){
                    // 在后半段
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
    }
}
