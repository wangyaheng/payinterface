package leetcode.order;

import java.util.Arrays;

/**
 * 冒泡排序O（n*n）
 * 每次比较相邻的两个数，大的数向后移
 */
public class Bubble {

    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };

        for(int i = 0;i<data.length;i++ ){
            for(int j = 0;j<data.length-1-i;j++){
                if(data[j]>data[j+1]){
                    // 交换位置
                    swap(data,j ,j+1 );
                }
            }
        }

        System.out.println(Arrays.asList(data));


    }
    private static void swap(int[] data,int i ,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
