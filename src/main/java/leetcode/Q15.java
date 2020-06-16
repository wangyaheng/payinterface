package leetcode;


import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class Q15 {

    public static void main(String[] args) {
        Q15 q15 = new Q15();
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 排序后进行双指针法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3)return result;
        Arrays.sort(nums);

        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0)return result;
            if(i>0&&nums[i]==nums[i-1])continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right && nums[left] == nums[left+1]) left++; // 去重
                    while (left<right && nums[right] == nums[right-1]) right--; // 去重
                    right--;
                    left++;
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }

    /**
     * 回溯法超出时间限制
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Map<String,List<Integer>> result = new HashMap<>();
        backTrace(3, nums, 0, new ArrayList<Integer>(),result);
        return new ArrayList<>(result.values());
    }

    public static void backTrace(int total,int[] nums ,int start,List<Integer> tempList,Map<String,List<Integer>> result){

        if(total==0){
            ArrayList<Integer> arrayList = new ArrayList<>(tempList);
            Collections.sort(arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            arrayList.forEach((a)->stringBuilder.append(a));
            int sum = 0;
            for (Integer o : arrayList) {
                sum+=o;
            }

           if(sum==0)result.put(stringBuilder.toString(), arrayList);

        }else{
            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                backTrace(total-1, nums,i+1, tempList,result);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
