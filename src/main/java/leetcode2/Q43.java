package leetcode2;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 示例 1:
 输入: num1 = "2", num2 = "3"
 输出: "6"

 */
public class Q43 {

    public static void main(String[] args) {

        /*String num = "123";
        for (int i = 0; i < num.length(); i++) {
            System.out.println(num.charAt(i));
            int c = (int)num.charAt(i);
            System.out.println(c-'0');

        }*/
        System.out.println(multiply("123", "456"));

    }

    public static String multiply(String num1, String num2) {

        if(num1.equals("0")||"0".equals(num2)) return "0";
        // 存放结果
        int[] res = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1;i>=0;i--){
            int n = num1.charAt(i)-'0';// 从个位依次取出每一个数
            for(int j = num2.length()-1;j>=0;j--){
                // 从个位依次取出每一个数
                int m = num2.charAt(j)-'0';
                int sum = res[i+j+1]+(n*m);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;

            }

        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(i==0&&res[i]==0){
                continue;
            }
            builder.append(res[i]);
        }
        return builder.toString();
    }
}
