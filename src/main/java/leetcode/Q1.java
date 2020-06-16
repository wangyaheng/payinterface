package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Q1 {

    public static void main(String[] args) {
        System.out.println(-3>0);
        int target = 0;
        int[] nums = new int[]{-2,2,8,12,7};
        int[] cal = cal(target, nums);

        System.out.println(""+cal[0]+cal[1]+"");
    }

    public static int[] cal(int target,int[] nums){
        for (int i = 0;i<nums.length;i++){
            int numi = nums[i];
            if(numi>target)continue;
            for (int j = i+1;j<nums.length;j++){
                System.out.println(j);
                int numj = nums[j];
                if(numj>target)continue;
                if((numi+numj)==target) return new int[]{i,j};
            }

        }
        return null;
    }

    public static int[] cal2(int target,int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                 return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
