package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * 给你两个整数 n和k，从1-n中选择k个数字的组合。比如n=4，那么从1,2,3,4中选取两个数字的组合
 * 博客地址：https://blog.csdn.net/versencoder/article/details/52071930
 */
public class BackTrace {

    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);

        System.out.println(combine);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        backreace(n,k ,list ,1 );
        return result;

    }

    /**
     *
     * @param n
     * @param k
     * @param list 符合的值要放入的list
     * @param start 开始索引
     */
    public static void backreace(int n ,int k,List<Integer> list,int start){
        if(k<0) return;
        else if(k==0) result.add(new ArrayList<>(list));
        else{
           for(int i = start;i<=n;i++){
               list.add(i);
               backreace(n,k-1 ,list ,i+1 );
               list.remove(list.size()-1);
           }
        }


    }

}
