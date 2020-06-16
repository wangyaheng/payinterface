package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 例如，给出 n = 3，生成结果为：
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class Q22 {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);

    }
    /**
     *回溯法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result,"" ,0 ,0 ,n );
        return result;
    }

    public static void backtrace(List<String> result,String currentStr,int open,int close,int max){
        if(currentStr.length()==max*2){
            result.add(currentStr);
            return;
        }

        if(open<max){
            backtrace(result,currentStr+"(",open+1,close,max);
        }
        if(close<open){
            backtrace(result,currentStr+")" ,open ,close+1 ,max );
        }
    }
}
