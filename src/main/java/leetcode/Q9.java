package leetcode;

import utils.StringUtils;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Q9 {

    public static void main(String[] args) {
        int a = -123321;
        System.out.println(isPalindrome(a));
    }

    /**
     * 官方解题
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
       if(x<0||(x%10==0&&x!=0)) return false;
       int reverseNum = 0;
       // 如果反转到一半x不大于reverseNum，可以肯定不是回声数，最后也肯定返回false
       while (x>reverseNum){
           reverseNum = reverseNum*10+x%10;
           x = x/10;
       }
       return reverseNum==x||reverseNum/10==x;
    }


    public static boolean isPalindrome1(int x) {
        String s = ""+x;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        StringBuilder reverse = stringBuilder.reverse();
        return s.equals(reverse.toString());
    }
}
