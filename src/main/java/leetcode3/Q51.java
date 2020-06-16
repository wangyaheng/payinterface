package leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 示例:
 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。
 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。
 当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）


 */
public class Q51 {

    public static void main(String[] args) {
        solveNQueens(4);
    }

    /**
     * 回溯法解决问题
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String [][] board = new String[n][n];// 初始化二维棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               board[i][j] = ".";
            }
        }
        backtrace(result,list ,0 ,board );

        System.out.println(result);
        return result;
    }

    public static void backtrace(List<List<String>> result,List<String> list,int row,String [][] board){
        if (row == board.length) {
            List<String> ll = new ArrayList<>();
            // 找到结果  加入结果集
            for (int i = 0; i < board.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    builder.append(board[i][j]);
                    System.out.print(board[i][j]+" ");
                }
                ll.add(builder.toString());
                System.out.println();
            }
            result.add(ll);
            System.out.println("----------------------");
           return;
        }else{
            // 继续回溯
            for (int i = 0; i < board.length; i++) {
                // 判断这个位置是否可以放置皇后
                if(!isValid(row,i,board)){
                    continue;
                }
                board[row][i] = "Q";
                backtrace(result,list ,row+1 ,board );
                board[row][i] = ".";

            }
        }
    }

    /**
     *
     * @param row 行
     * @param i 列
     * @return
     */
    private static boolean isValid(int row, int i,String [][] board) {
        if(row==0) return true;
        if(row==board.length){
            return false;
        }
        // 判断此列有没有皇后
        for (int j = 0; j < row; j++) {
            if("Q".equals(board[j][i])){
                return false;
            }
        }
        // 判断左上角对角线有没有皇后
        for (int r = row-1,c=i-1; r>=0&&c>=0;r--,c--) {
            if("Q".equals(board[r][c])) return false;
        }

        // 判断右上角有没有皇后
        for (int r = row-1,c=i+1; r>=0&&c<board.length;r--,c++) {
            if("Q".equals(board[r][c])) return false;
        }
        return true;
    }

}
