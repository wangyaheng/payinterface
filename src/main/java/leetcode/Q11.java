package leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 */
public class Q11 {

    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

    /**
     * 双指针法
     * 由于面积取决于边长短的那一端假设为m，所以要想得到比当前更大的面积，
     * 边长短的那一端必须舍弃，因为如果不舍弃，高最大就是m，而随着指针的移动宽会一直减小，因此面积只会越来越小
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(Math.min(height[left], height[right])*(right-left), max);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }

        }
        return max;

    }
    /**
     * 暴力法
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;
        for (int i  = 0;i<height.length;i++) {
            for(int j=i+1;j<height.length;j++){
                max = Math.max(Math.min(height[i],height[j])*(j-i), max);
            }
        }
        return max;
    }
}
