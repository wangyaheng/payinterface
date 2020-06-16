package leetcode3;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 网格中的障碍物和空位置分别用 1 和 0 来表示。
 说明：m 和 n 的值均不超过 100。

 */
public class Q63 {

    public static void main(String[] args) {
        int[][] o = {{0,0,0},{0,1,0}, {0,0,0}};
        System.out.println(uniquePathsWithObstacles(o));
    }

    /**
     * 和上一题思路类似只是如果有障碍物就直接设置为0即可
     * 初始化第一行和第一列的时候 如果有障碍物 障碍物后面的都为0
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid[0].length;// 矩阵的列数
        int[][] dp = new int[obstacleGrid.length][length];
        if(obstacleGrid[0][0]==1) return 0;//有障碍物直接返回0
        else dp[0][0]=1;

        for (int i = 1; i < obstacleGrid.length; i++) {
            // 初始化第一列
            if(obstacleGrid[i][0]==1) dp[i][0]=0;
            else dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < length; i++) {
            // 初始化第一列
            if(obstacleGrid[0][i]==1) dp[0][i]=0;
            else dp[0][i] = dp[0][i-1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < length; j++) {
                if(obstacleGrid[i][j]==1)dp[i][j]=0;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }

        }
        return dp[obstacleGrid.length-1][length-1];
    }
}
