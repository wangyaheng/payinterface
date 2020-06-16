package leetcode3;

import com.sun.jdi.PathSearchingVirtualMachine;

/**
 * 实现 int sqrt(int x) 函数。
 计算并返回 x 的平方根，其中 x 是非负整数。
 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 示例 1:
 输入: 4
 输出: 2
 示例 2:
 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。
 */
public class Q69 {

    public static void main(String[] args) {
        System.out.println(46340*46340);
        System.out.println(mySqrt1(6));
    }

    public static int mySqrt(int x) {
        if(x==0)return 0;
        int result = 1;
        while(result<=x/result){
            result++;
        }

        return result-1;
    }

    /**
     *二分法
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        if(x==0)return 0;
        int l = 0,r = x,result = 0;
        while(l<=r){
            int mid = (l+r)/2;
           if((long)mid*mid>x){
                //在左侧
                r = mid-1;
            }else{
                l = mid+1;
               result = mid;
            }
        }
        return result;
    }
}
