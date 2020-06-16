package leetcode;

/**
 * 实现 strStr() 函数。
 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 示例 1:
 输入: haystack = "hello", needle = "ll"
 输出: 2
 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 对于本题而言，当 needle 是空字符串时我们应当返回 0

 */
public class Q28 {
    /**
     *
     * 这个算法看不懂！！！
     * KMP算法  暴力法指针会回退果字符串中重复的字符比较多，该算法就显得很蠢
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if("".equals(needle)||needle==null) return 0;

        return -1;
    }
}
