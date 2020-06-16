package algorithm;

/**
 * 数组的差
 * 一个数字减去它右边的子数组的一个数字得到的一个差值，求所有差值可能的最大值
 */
public class ArrayDiffer {

    public static void main(String[] args) {
        int [] nums = new int[]{1,4,17,3,2,9,1};
        System.out.println(maxArrayDiff(nums));
    }

    /**
     * 动态规划
     * @return
     */
    public static int maxArrayDiff(int [] nums){
        if(nums.length<=1) return Integer.MIN_VALUE;
        int[] dip = new int[nums.length];
        int[] max = new int[nums.length];
        dip[0] = 0;
        max[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            dip[i] = Math.max(dip[i-1], max[i-1]-nums[i]);
            max[i] = Math.max(nums[i],max[i-1] );
        }

        return dip[nums.length-1];
    }
}
