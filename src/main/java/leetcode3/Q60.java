package leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。
 说明：
 给定 n 的范围是 [1, 9]。
 给定 k 的范围是[1,  n!]。
 示例 1:
 输入: n = 3, k = 3
 输出: "213"
 */
public class Q60 {


    public static void main(String[] args) {

        System.out.println(getPermutation(3, 2));

    }
    public static String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        boolean [] use = new boolean[n];

        StringBuilder builder = new StringBuilder();
        backTrace(n,result ,builder ,use ,k);
        return result.get(k-1).toString();
    }

    public static void backTrace(int n, List<String> result, StringBuilder builder,boolean [] use,int k){
        if(result.size()==k) return;
        if(n==0){
            result.add(new String(builder));
            return;
        }else{
            for (int i = 0; i < use.length; i++) {
                if(use[i]){
                    continue;
                }
                builder.append(i+1);
                use[i]= true;
                backTrace(n-1,result ,builder , use,k);
                builder.deleteCharAt(builder.length()-1);
                use[i] = false;
            }
        }

    }
}
