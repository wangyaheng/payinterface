package leetcode2;

import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

 输入:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 输出: true
 */
public class Q36 {


    public static void main(String[] args) {
        char[][] a = {{'8','3','.','.','7','.','.','.','.'}
                     ,{'6','.','.','1','9','5','.','.','.'}
                     ,{'.','9','8','.','.','.','.','6','.'}
                     ,{'8','.','.','.','6','.','.','.','3'}
                     ,{'4','.','.','8','.','3','.','.','1'}
                     ,{'7','.','.','.','2','.','.','.','6'}
                     ,{'.','6','.','.','.','.','2','8','.'}
                     ,{'.','.','.','4','1','9','.','.','5'}
                     ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(a));

    }


    public static boolean isValidSudoku(char[][] board) {

        // 行
        HashMap<Integer,Integer> [] rows = new HashMap[9];
        HashMap<Integer,Integer> [] colums= new HashMap[9];
        HashMap<Integer,Integer> [] indexBox= new HashMap[9];

        for(int i = 0;i<9;i++){
            rows[i] = new HashMap<>();
            colums[i] = new HashMap<>();
            indexBox[i] = new HashMap<>();
        }

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){

                // 判断每一行每一列每一个子宫格内是否有重复数字
                // 计算小宫格的序号
                int boxInedx = (i/3)*3+j/3;
                HashMap<Integer, Integer> row = rows[i];
                HashMap<Integer, Integer> colum = colums[j];
                HashMap<Integer, Integer> box = indexBox[boxInedx];
                if('.'!=board[i][j]){
                    if(row.get((int)board[i][j])!=null) return false;
                    if(colum.get((int)board[i][j])!=null) return false;
                    if(box.get((int)board[i][j])!=null) return false;
                    row.put((int) board[i][j],new Integer(1));
                    colum.put((int) board[i][j],new Integer(1));
                    box.put((int) board[i][j],new Integer(1));
                }


            }
        }
        return true;
    }
}
