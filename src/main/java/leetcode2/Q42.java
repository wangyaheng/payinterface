package leetcode2;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨z`
 */
public class Q42 {
    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
        System.out.println(trap1(heights));
    }
    /**
     * 暴力解法 时间复杂度O（n^2）
     * 不考虑整体 只考虑每一格能接到的雨水量 就是左边和右边的最大值的较小一个减去当前的值
     * @return
     */
    public static int trap(int[] heignt){
        if(heignt.length<2)return 0;
        int ans = 0;
        for (int i = 0; i < heignt.length; i++) {
            int leftMax=0,rightMax = 0;
            for (int j = i;j>=0;j--){
                // 寻找左边的最大值
                leftMax = Math.max(heignt[j],leftMax);
            }
            for (int k = i;k<heignt.length;k++){
                // 寻找左边的最大值
                rightMax = Math.max(heignt[k],rightMax);
            }
            ans+=Math.min(rightMax,leftMax)-heignt[i];

        }

        return ans;
    }

    /**
     * 动态法 时间复杂度O（n），对暴力法的一种改进  可以先将每个位置的最大值最小值线存储起来
     * @param height
     * @return
     */
    public static int trap1(int[] height){
        if(height.length<2)return 0;
        int ans = 0;
        int [] leftMaxArray = new int[height.length];
        int [] rightMaxArray = new int[height.length];
        int leftmax = 0;
        for (int i = 0; i < height.length; i++) {
            leftmax = Math.max(leftmax,height[i]);
            leftMaxArray[i] = leftmax;
        }
        int rightMax = 0;
        for (int i = height.length-1; i >=0 ; i--) {
            rightMax = Math.max(rightMax,height[i]);
            rightMaxArray[i] = rightMax;
        }
        System.out.println(JsonUtils.toJsonString(leftMaxArray));
        System.out.println(JsonUtils.toJsonString(rightMaxArray));
        for (int i = 0; i < height.length; i++) {
            ans+=Math.min(rightMaxArray[i],leftMaxArray[i])-height[i];
        }
        return ans;
    }


}
