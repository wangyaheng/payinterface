package leetcode;


/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 返回被除数 dividend 除以除数 divisor 得到的商。
 示例 1:
 输入: dividend = 10, divisor = 3
 输出: 3

 */
public class Q29 {

    public static void main(String[] args) {

        int a = -34;
        System.out.println(opposite(a));
        System.out.println(Math.abs(-21474));
        System.out.println(divide(10, 3));
    }

    /**Integer.MINVAL不能转化为正数的int类型，因此可以都转化为负数
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if (dividend > divisor) {
            return 0;
        }

        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        if(a == Integer.MIN_VALUE){
            if( sign > 0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else{
            if(sign > 0){
                return opposite(a);
            }else{
                return a;
            }
        }
    }

    /**
     * 求一个数的补码，计算机中的减法运算是用补码相加，结果在求补码完成的
     * ~x + 1  就是在java中求补码的方式
     * 因此0-x的补码就是~x + 1  就是对数去相反数
     * @param x
     * @return x的相反数
     */
    public static int opposite(int x) {
        return ~x + 1;
    }


}
