package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Q5 {

    public static void main(String[] args) {
        String str = "bbasdfasdfasdfasdfasdfasdfgfdsghh";
        String s = longestPalindrome(str);
        System.out.println(s);

    }

    /**
     * 马拉车算法  时间复杂度O（n）
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String s1 = preProcess(s);
        int length = s1.length();
        int []p = new int[length];// 各个中心回声字符串的长度
        int c=0,r=0;// 当前回声字符串中心和半径

        for(int i=0;i<s1.length()-1;i++){
            int i_mirror = c-(i-c);//对称点
            // 当前点是否在上一个中心的半径内
            int diff = r-i;
            if(diff>0){
                // 在半径内，查询堆成点的回声字符串的长度
                int i1 = p[i_mirror];
                if(i1<diff){
                    //在半径内，回声字符串的长度等于i1
                    p[i]=i1;
                }else{
                    // 需要计算回声字符串的长度
                    while (s1.charAt(i + p[i] + 1) == s1.charAt(i - p[i] - 1)){ p[i]++; }
                    c=i;
                    r=i+p[i];
                }

            }else{
                // 不在半径内
                p[i] = 0;
                while (s1.charAt(i + p[i] + 1) == s1.charAt(i - p[i] - 1)) { p[i]++; }
                c= i;
                r = i + p[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < length - 1; i++) {
             if (p[i] > maxLen) {
                 maxLen = p[i];
                centerIndex = i;
             }
        }

        return s.substring((centerIndex - 1 - maxLen) / 2, (centerIndex - 1 - maxLen) / 2 + maxLen);
    }

    static String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.substring(i, i + 1);
        }

        ret += "#$";
        return ret;
    }

    /**
     * 中心扩展算法 时间复杂度O（n^2）
     * 共有2n+1种扩展
     *
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        String finalStr = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expandStr(s, i, i);
            String s2 = expandStr(s, i, i + 1);
            String max = s1.length() > s2.length() ? s1 : s2;
            if (max.length() > finalStr.length()) finalStr = max;
        }

        return finalStr;
    }

    private static String expandStr(String s, int left, int right) {
        String str = "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            str = s.substring(left, right + 1);
            left--;
            right++;
        }
        return str;
    }

    /**
     * 暴力破解法 时间复杂度 O(n^3)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() <= 1) return s;
        String finalString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isEcho(substring) && substring.length() > finalString.length()) {
                    finalString = substring;
                }
            }
        }
        return finalString;
    }

    private static boolean isEcho(String string) {
        return new StringBuilder(string).reverse().toString().equals(string);
    }


}
