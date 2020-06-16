package leetcode2;

import com.lefu.commons.utils.lang.JsonUtils;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 说明：
 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 示例 1:
 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 1 4 7
 2 5 8
 3 6 9
 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 */
public class Q48 {

    public static void main(String[] args) {
       /* int [] a =new  int[]{1,2,3};
        int[] b = a;
        a[0] = 5;
        System.out.println(JsonUtils.toJsonString(b));*/

        int[][] matrix2={{1,2,3,4}
                        ,{5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        rotate(matrix2);
       // printint2(matrix2);

    }

    public static void rotate(int[][] matrix) {
        // 先专置矩阵 在反转每一行
        int [][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            // 第i行数据
            int[] matrix1 = temp[i];

            // 第i行应该放到第n-i-1

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length-i-1] = matrix1[j];
            }
        }
        printint2(matrix);


    }

    public static void printint2(int [][] nums){
        for (int i = 0; i < nums.length; i++) {
            int[] num = nums[i];
            for (int j = 0; j < num.length; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
}
