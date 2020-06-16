package leetcode3;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Q65 {

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9});
        System.out.println(JsonUtils.toJsonString(ints));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        ints[1] = 0;
        for (int i = 1; i < digits.length; i++) {
            ints[i + 1] = digits[i];
        }
        return ints;


    }
}
