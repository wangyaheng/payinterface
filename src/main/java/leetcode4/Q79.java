package leetcode4;

import leetcode.BackTrace;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Q79 {
    private static int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
       /* char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCEF";
*/
        char[][] board =
                {
                        {'A','A'}

                };

        String word = "AA";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] mark = new boolean[board.length][board[0].length];
        if (row == 0) return false;
        if(row==1&&col==1&&word.charAt(0)==board[0][0]) return true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (word.charAt(0) != c) {
                    // 不符合条件
                    continue;
                } else {
                    // 进行回溯
                    if (backTrace(board, word, word.length(), i, j, mark)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean backTrace(char[][] board, String word, int length, int i, int j, boolean[][] mark) {
        if (length == 0) {
            return true;
        } else {
            // 从四个方向找符合条件的元素
            if (word.charAt(word.length()-length) == board[i][j]) {
                mark[i][j] = true;
                for (int k = 0; k < direction.length; k++) {
                    int newX = i + direction[k][0];
                    int newy = j + direction[k][1];
                    if (isaArea(newX, newy, board) && !mark[newX][newy]) {
                        if (backTrace(board, word, length - 1, newX, newy, mark)) {
                            return true;
                        }
                    }
                }
                mark[i][j] = false;
            }

        }
        return false;

    }

    public static boolean isaArea(int i, int j, char[][] board) {
        return i < board.length &&i >=0 && j < board[0].length && j>=0;
    }


}
