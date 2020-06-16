package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 */
public class Q20 {

    private Map<Character,Character> mappings;

    public Q20(){
        mappings = new HashMap<>();
        mappings.put(')','(' );
        mappings.put(']','[' );
        mappings.put('}','{' );
    }

    /**
     * 利用栈的特性
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(mappings.containsKey(c)&&!stack.isEmpty()){
                Character pop = stack.pop();
                if(mappings.get(c)!=pop){
                    return false;
                }

            }else if(mappings.containsValue(c)){
                stack.push(c);
            }

        }

        return stack.isEmpty();
    }
}
