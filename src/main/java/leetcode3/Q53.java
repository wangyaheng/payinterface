package leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 把一个矩阵顺时针输出
 */
public class Q53 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();// 记录结果
        if(matrix.length==0) return list;
        // 记录某一个节点是否走过
        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        int [] dr = new int[]{0,1,0,-1};// row的移动方向
        int[] dc = new int[]{1,0,-1,0};// 列的移动方向
        int R = matrix.length;
        int C = matrix[0].length;
        int r = 0,c = 0,di = 0;
        for (int i = 0; i < R*C; i++) {
            list.add(matrix[r][c]);
            seen[r][c] = true;
            int rr = r+dr[di];
            int cc = c+dc[di];
            if(0 <= rr && rr < R && 0 <= cc && cc < C && !seen[rr][cc]){
                r = rr;
                c = cc;
            }else{
                di = (di+1)%4;
                r = r+dr[di];
                c = c+dc[di];
            }
        }

        return list;
    }
}
