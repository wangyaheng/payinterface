package algorithm;

/**
 * 给定一个数组求子数组的最大和
 */
public class MaxSUm {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,4,8,-4,7,-1,-5};
        System.out.println(maxNum(nums));
        System.out.println(maxNum1(nums));
        System.out.println(maxNum2(nums));
    }

    /**
     * 使用动态规划 时间复杂度O（n）
     * dp[i]而言只有两种情况，如果dp[i - 1] > 0, 那么dp[i] = dp[i - 1] + a[i];不然，dp[i] = a[i]
     * @param nums
     * @return
     */
    public static int maxNum2(int[] nums){
        int numsLength = nums.length;
        int maxNum = Integer.MIN_VALUE;
        // 定义状态机
        int[] dp = new int[numsLength];

        dp[0] = nums[0]>=0?nums[0]:0;
        for (int i = 1; i < numsLength; i++) {
            dp[i] = dp[i-1]>=0?dp[i-1]+nums[i]:nums[i];
            if(dp[i]>maxNum) maxNum = dp[i];
        }
       return maxNum;
    }
    /**
     * 暴力法 时间复杂度 O(n^3)
     * @return
     */
    public static int maxNum(int[] nums){
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int thisNum = 0;
                for (int k =i; k < j; k++) {
                    thisNum+=nums[k];
                    if(thisNum>maxNum){
                        maxNum = thisNum;
                    }
                }
            }
        }
        return maxNum;
    }

    /**
     * 暴力改进法 时间复杂度O（n^2）
     * @param nums
     * @return
     */
    public static int maxNum1(int[] nums){
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int thisNum = 0;
            for (int j = i; j < nums.length; j++) {
                thisNum+=nums[j];
                if(thisNum>maxNum){
                    maxNum = thisNum;
                }
            }
        }
      return maxNum;
    }

}
