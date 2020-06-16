package leetcode.order;

import java.util.Arrays;

/**
 * 归并排序
 * 先分开，在合并
 */
public class MergeSort {
    public static void main(String[] args) {
        int data[] = {9,5,6,8,0,3,7,1,20,1};
        mergeSort(data, 0, data.length -1);
        System.out.println(Arrays.toString(data));
        //String a = "1";
        //String b = "2";
        //a.compareTo(b);
    }

    public static void mergeSort(int[] data,int left,int right){
        if(left<right){
            //分
            int mid = (left+right)/2;
            mergeSort(data,left ,mid );
            mergeSort(data,mid+1 ,right );
            // 以上就是分
            //合并
            merge(data,left,mid,right);
        }
    }

    public static void merge(int[] data,int left,int mid,int right){
        int temp[] = new int[data.length];// 用来辅助排序
        int point1 = left;//左边数组的第一个元素
        int point2 = mid+1;//右边数组第一个元素
        int loc = left;
        while(point1<=mid&&point2<=right){
            if(data[point1]<data[point2]){
                // 将小的元素放大数组中
                temp[loc] = data[point1];
                loc++;
                point1++;
            }else {
                temp[loc] = data[point2];
                loc ++ ;
                point2 ++ ;
            }

        }
        //如果其中过一个数组已经全部放入到临时数组中，处理另一个未放完的数组
        while(point1<=mid){
            temp[loc++] = data[point1++];
        }
        while(point2 <= right) {
            temp[loc++] = data[point2++];
        }
        // 将临时数组中的元素放入到data中
        for(int i = left ;i <= right ; i++) {
            data[i] = temp[i];
        }
    }

}
