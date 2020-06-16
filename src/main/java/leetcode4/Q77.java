package leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 示例:
 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 */
public class Q77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(result,1 , n,k ,new ArrayList<Integer>());
        return result;
    }


    public static void backTrace(List<List<Integer>> result,int start,int n,int k,List<Integer> list){
        if(k==0){
            // 找到结果
            result.add(new ArrayList<>(list));
        }else{
            for (int i = start; i <=n; i++) {
                list.add(i);
                backTrace(result,i+1 ,n ,k-1 , list);
                list.remove(list.size()-1);
            }
        }
    }
}
