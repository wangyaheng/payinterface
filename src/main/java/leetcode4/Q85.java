package leetcode4;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 示例:
 输入:
 [
 ["1","0","1","0","0"],
 ["1","0","1","1","1"],
 ["1","1","1","1","1"],
 ["1","0","0","1","0"]
 ]
 输出: 6

 */
public class Q85 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int maxAarea = 0;
        // 每个坐标在其所在行的最大宽度
        int [][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1') {
                    dp[i][j]= j==0?1:dp[i][j-1]+1;
                    int width = dp[i][j];
                    // 循环当前列 找出最小宽度和行间距相乘就是面积
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width,dp[k][j]);
                        maxAarea = Math.max((i-k+1)*width, maxAarea);
                    }
                }

            }
        }
        return maxAarea;
    }
}
