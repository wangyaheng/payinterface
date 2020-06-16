package leetcode4;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 你可以对一个单词进行如下三种操作：
 插入一个字符
 删除一个字符
 替换一个字符
 示例 1：
 输入：word1 = "horse", word2 = "ros"
 输出：3
 解释：
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')

 */
public class Q72 {

    public static void main(String[] args) {
        int i = minDistance("horse", "ros");
        System.out.println(i);

    }

    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化第一行和第一列
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;

                dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,left_down));
            }
        }

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];

    }
}
