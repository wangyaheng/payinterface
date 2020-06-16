package leetcode4;

import org.apache.log4j.xml.SAXErrorHandler;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 该矩阵具有如下特性：
 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 示例 1:
 输入:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 输出: true
1 3 5 7 8 9     5
 */
public class Q74 {

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix, 11));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        // 二分法在第一列中找到目标行，在遍历某一行
        int r = row-1,l = 0;
        int mid = -1;
        while(l<=r){
            mid = (l+r)/2;
            if(matrix[mid][0]<=target){
                // 在右侧
                l = mid+1;
            }else if(matrix[mid][0]>target){
                r = mid-1;
            }
        }
        // l-1 值就是target可能所在的行
        int targetr = (l-1)<0?l:l-1;
        int [] targetRow = matrix[targetr];
        for (int i = 0; i < targetRow.length; i++) {
            if(targetRow[i]==target) return true;
            if(targetRow[i]>target) return false;

        }
        return false;

    }
}
