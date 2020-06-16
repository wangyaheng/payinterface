package leetcode4;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Q75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        sortColors(nums);
        System.out.println(JsonUtils.toJsonString(nums));
    }

    /**
     * 荷兰国旗  三指针
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int current = 0;
        if (nums.length <= 1) return;
        while (current <= p2) {
            if (nums[current] == 0) {
                // 当前位置和p0交换
                swap(current++, p0, nums);
                p0++;

            } else if (nums[current] == 2) {
                // 当前指针和 p2交换位置\
                swap(current, p2, nums);
                p2--;

            } else {
                current++;
            }

        }

    }

    private static void swap(int i, int j, int[] nums) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
