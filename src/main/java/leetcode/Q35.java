package leetcode;

/**
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 你可以假设数组中无重复元素。
 输入: [1,3,5,6], 5
 输出: 2
 */
public class Q35 {
    public static void main(String[] args) {
        int [] data = new int[]{3,5,7,9,10};
        System.out.println(getTarget(data, 8));
    }

    public static int getTarget(int[] data,int target){
        //二分法
        int left = 0,right = data.length-1;
       while(left<=right){
           int mid = (left+right)/2;
           if(data[mid]==target){
               return mid;
           }else if(data[mid]>target){
               // 在左侧
               right = mid-1;
           }else{
               // 在右侧
               left = mid+1;
           }
       }
       return left;

    }

}
