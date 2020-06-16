package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法2
 * 给你一个正数数组candidate[],一个目标值target，寻找里面所有的不重复组合，让其和等于target，给你[2,3,6,7] 2+2+3=7 ,7=7,所以可能组合为[2,2,3],[7]）
 */
public class BackTrace2 {

    public static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        List<List<Integer>> num = getNum(new int[]{1, 2}, 8);

        System.out.println(num);
    }

    public static List<List<Integer>> getNum(int[] candidate,int target){

        backTrace(new int[]{1,2,3,4,5,6,7,8}, 8, new ArrayList<Integer>(),0);
        return result;
    }

    public static void backTrace(int[] candidate,int target,List<Integer> tempList,int start){
        if(getListSum(tempList)==target){
            result.add(new ArrayList<>(tempList));
        }else{
           for(int i=start;i<candidate.length;i++){
                tempList.add(candidate[i]);
                backTrace(candidate,target ,tempList,i+1);
               tempList.remove(tempList.size()-1);
            }
        }
    }

    public static int getListSum(List<Integer> list){
        if(list.size()==0) return 0;
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
