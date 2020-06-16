package leetcode2;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 示例 1:
 输入: [1,2,0]
 输出: 3

 输入: [3,4,-1,1]
 输出: 2
 */
public class Q41 {

    public static void main(String[] args) {
        int i = firstMissingPositive(new int[]{2,1});
        System.out.println(i);
    }

    /**
     * 官方解题
     * @return
     */
    public static int firstMissingPositive1(int[] nums){
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                count1++;
                break;
            }
        }
        if(count1==0) return 1;
        if(nums.length==1){
            return 2;
        }

        // 将所有>n和《0的数替换成1
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<0||nums[i]>nums.length){
                nums[i]=1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if(a==nums.length){
                // 放置在0的未知
                nums[0]=-Math.abs(nums[0]);
            }else{
                nums[a]=-Math.abs(nums[a]);
            }
        }

        // 第一个负数就是要找的值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return nums.length;

        return nums.length + 1;

    }
    /**
     * 如果数组长度是n 那么最小正整数肯定是>0&&<n+1
     * 可以在原数组上建立一个hash表，数组下标即是值 大于n的值可以直接丢弃
     * 构建完hash表之后循环找出第一个没有值的即是最小正整数
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        // 构建hash表

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums[i] - 1, i,nums);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;



    }

    public static void swap(int i,int j,int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
