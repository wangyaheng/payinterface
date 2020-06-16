package leetcode2;

/**
 * 外观数列
 * 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211

 */
public class Q38 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

        }
        System.out.println(countAndSay(6));

    }
    /**
     * 输入一个数，他的外观数列
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if(1==n) return "1";

        StringBuilder stringbuilder = new StringBuilder();// 存储本次递归的结果
        //递归求出上一个数的外观数列
        String s = countAndSay(n - 1);
        char prev = (char)-127;
        int count = 1;
        for(int i = 0;i<s.length();i++){
            if(i==0){
                prev = s.charAt(0);
                continue;
            }
            if(s.charAt(i)==prev){
              count++;
              continue;
            }
            stringbuilder.append(count).append(prev);
            count = 1;
            prev = s.charAt(i);
        }
        stringbuilder.append(count).append(prev);
        return stringbuilder.toString();
    }
}
