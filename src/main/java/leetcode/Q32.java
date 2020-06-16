package leetcode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 示例 1:
 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 */
public class Q32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

    /**
     * 栈
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
               stack.pop();// 删除栈的值
               if(stack.isEmpty()){
                   stack.push(i);
               }else{
                   maxLength = Math.max(maxLength, i - stack.peek());// peek不改变栈的值
               }
            }
        }
        return maxLength;
    }
    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int maxLength = 0;
        int dp[] = new int[s.length()];
        for(int i = 1;i<s.length();i++){
            Character c = s.charAt(i);
            if(c.equals(')')){

                if(c.equals(')')){
                    dp[i]= i>=2?dp[i-1]+2:2;
                }else if(i-dp[i-1]>0&&s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);

        }
        return maxLength;
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxLegth = 0;
        for(int i = 0;i<s.length();i++){
            for(int j = i+2;j<=s.length();j+=2){
                String substring = s.substring(i, j);
                if(isValid(substring)){
                    maxLegth = Math.max(maxLegth,substring.length());
                }
            }
        }
        return maxLegth;
    }

    /**
     * 判断一个字符串是否符合括号的标准
     * @param s
     * @return
     */
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            Character c = s.charAt(i);
            if(c.equals('(')){
                // 压入栈中
                stack.push(c);
            }else if(!stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }


}
