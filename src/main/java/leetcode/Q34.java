package leetcode;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 你的算法时间复杂度必须是 O(log n) 级别。
 如果数组中不存在目标值，返回 [-1, -1]。
 例如：
 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 */
public class Q34 {

    public static void main(String[] args) {
        int[] data = new int[]{2,2};
        int[] result = new int[2];
        getIndex(data, 1, 0, data.length-1,result);
        System.out.println(JsonUtils.toJsonString(result));



    }

    private static void getIndex(int[] data,int target,int ll,int rr,int [] result){
        if(ll<0||rr<0){
            result[0]=-1; result[1]=-1;
            return;
        }
        if(ll>=rr) {
            if(data[ll]==target) {result[0]=ll; result[1]=ll; return;}
            if(data[rr]==target) {result[0]=rr; result[1]=rr; return;}
            result[0]=-1; result[1]=-1;
            return;
        }
        int half =(rr+ll)/2;
        if(data[half]==target){
            // 找到左右的相等的
            int left = half;
            int right = half;
            while(left>=ll&&data[left]==target){
                left--;
            }
            while(right<=rr&&data[right]==target){
                right++;
            }
            result[0]=left+1; result[1]=right-1;
            return;
        }else if(data[half]>target){
            // 在左侧
            getIndex(data,target,ll,half-1,result);
        }else{
            // 在右侧
            getIndex(data,target,half+1,rr,result);
        }

    }


}
