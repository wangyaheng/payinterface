package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 示例:
 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Q46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums,3 ,result ,new ArrayList<Integer>() ,new boolean[nums.length] );
        return result;
    }

    /**
     *
     * @param nums 数字序列
     * @param n 剩余要找的数字个数
     * @param result 结果
     * @param list 存储单次的结果
     * @param use 是否用过这个节点
     */
    public static void backTrace(int[] nums,int n,List<List<Integer>> result,List<Integer> list,boolean[] use){
        if(n==0) {
            result.add(new ArrayList<>(list));
            return;
        }else{
            // 进行回溯
            for (int i = 0; i < nums.length; i++) {// 此处如果以i=start 为起点可以排除掉重复的节点需求如：[123][321]算一个节点

                if(use[i]){
                    continue;
                }
                list.add(nums[i]);
                use[i] = true;
                backTrace(nums, n-1,result ,list ,use);
                list.remove(list.size()-1);
                use[i] = false;
            }
        }
    }
}
