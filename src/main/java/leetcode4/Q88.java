package leetcode4;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 说明:
 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3
 输出: [1,2,2,3,5,6]

 */
public class Q88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0};
        int [] nums2 = new int[]{1};
        merge(nums1,0 ,nums2 ,1 );
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length==0) return;

        int[] ints = Arrays.copyOf(nums1, m);
        int nums1Index = 0;
        int nums2Index = 0;
        int i = 0;
        while(nums1Index<ints.length&&nums2Index<nums2.length){
            if(ints[nums1Index]>nums2[nums2Index]){
                nums1[i] = nums2[nums2Index];
                nums2Index++;
            }else{
                nums1[i] = ints[nums1Index];
                nums1Index++;
            }
            i++;
        }
        while(nums1Index<ints.length){
            nums1[i] = ints[nums1Index];
            nums1Index++;
            i++;
        }
        while(nums2Index<nums2.length){
            nums1[i] = nums2[nums2Index];
            nums2Index++;
            i++;
        }

    }
}
