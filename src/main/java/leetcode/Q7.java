package leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 示例 1:
 输入: 123
 输出: 321
 */
public class Q7 {

    public static void main(String[] args) {
        System.out.println(964632435l*10);
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    public static  int reverse(int x) {
        Long temp = 0l;
        Long y = Long.valueOf(x);
        while(y!=0){
            Long a = y%10l;
            temp = temp*10l+a;
            y = y/10l;
        }
        if(temp.intValue()!=temp) return 0;
        return temp.intValue();
    }
}

