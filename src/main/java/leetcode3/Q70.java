package leetcode3;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 注意：给定 n 是一个正整数。
 示例 1：
 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
处。
 */
public class Q70 {

    public static void main(String[] args) {
        System.out.println(climbStairs1(45));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    /**
     * 方法超出时间限制
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1)return 1;
        if(n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }


}
