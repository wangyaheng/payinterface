package leetcode4;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 此外，规范路径必须是表示绝对路径的最短字符串。
 输入："/home/"
 输出："/home"
 解释：注意，最后一个目录名后面没有斜杠
 */
public class Q71 {

    public static void main(String[] args) {

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            if("..".equals(split[i])){
                // 如果栈中还有数据就弹出第一个数据
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!"".equals(split[i])&&!".".equals(split[i])){
                stack.push(split[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            builder.append("/"+stack.get(i));
        }
        return builder.toString();

    }

}
