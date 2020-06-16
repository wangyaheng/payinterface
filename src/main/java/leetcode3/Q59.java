package leetcode3;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 示例:
 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */
public class Q59 {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();

        }

    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 整个矩阵的大小就是n行n列
        int [] dy = {1,0,-1,0};// 行的移动方向
        int[] dx = {0,1,0,-1};// 列的移动方向
        int dn = 0;// 转向的次数
        int row = 0;
        int col = 0;
        for (int i = 0; i < n*n; i++) {
            result[row][col] = i+1;
            // 判断是否需要转向
            if(i==(n-1)||i==2*(n-1)||i==3*(n-1)||result[row+dx[dn%4]][col+dy[dn%4]]!=0){
                // 转向
                dn++;
            }

            row = row+dx[dn%4];
            col = col+dy[dn%4];
        }
        return result;
    }
}
