package leetcode3;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 输入为 非空 字符串且只包含数字 1 和 0。
 示例 1:
 输入: a = "11", b = "1"
 输出: "100"

 */
public class Q66 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
    public static String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int l = Math.max(al,bl );
        if(bl>al) return addBinary(b,a );// 这样可以保证第一个参数总是大的
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = al-1; i >=0; i--) {
            char c = a.charAt(i);
            if('1'==c) carry++;
            if((al-i)<=bl&&b.charAt(i-al+bl)=='1') carry++;
            builder.append(carry%2);
            carry = carry/2;

        }
        if(carry==1)builder.append(carry);
        return builder.reverse().toString();
    }
}
