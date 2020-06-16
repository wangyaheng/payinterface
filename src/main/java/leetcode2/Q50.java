package leetcode2;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(myPow(0.44528, 0));
    }

    public static double myPow(double x,int n){
        if(n==0) return 1;
        double v = myFastPow(x, Math.abs(n));
        if(n>0)return v;
        else return 1/v;
    }
    public static double myFastPow(double x, int n) {
        if(n==1)return x;
        double v = myFastPow(x, n / 2);
        if(n%2==0){
            return v*v;
        }else{
            return v*v*x;
        }
    }
}
