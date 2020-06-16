package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 请你实现这个将字符串进行指定行数变换的函数：
 string convert(string s, int numRows);
 示例 1:
 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 */
public class Q6 {

    public static void main(String[] args) {
        String str = "AB";
        convert(str,1 );
    }

    /**
     *
     *  按行排序
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows<=1)return s;
        List<StringBuilder> list = new ArrayList<     >();
        for(int i=0;i<Math.min(s.length(), numRows);i++){
            list.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean goingDown = false;
        for(int i=0;i<s.length();i++){
           list.get(currentRow).append(s.charAt(i));
           if(currentRow==0||currentRow==numRows-1)goingDown=!goingDown;
           currentRow += goingDown?1:-1;

        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : list) ret.append(row);
        return ret.toString();

    }
}

