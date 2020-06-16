package algorithm.order;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 冒泡排序
 */
public class BubleOrder {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,56,2,9,4,5,45,76,23,44};
        for (int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    // 交换位置
                    swap(j,j+1 ,a );
                }
            }
        }
        System.out.println(JsonUtils.toJsonString(a));
    }

    public static void swap(int i,int j,int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
