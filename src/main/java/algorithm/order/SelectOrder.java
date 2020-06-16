package algorithm.order;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 选择排序
 * 每次选择一个最小的 与当前位置交换
 */
public class SelectOrder {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,56,2,9,4,5,45,76,23,44};

        for(int i = 0;i<a.length;i++){
            int minIndex = i;
            for(int j = i+1;j<a.length;j++){
               if(a[minIndex]>a[j]){
                   minIndex = j;
               }
            }
            // 交换
            swap(i,minIndex,a);
        }
        System.out.println(JsonUtils.toJsonString(a));
    }

    public static void swap(int i,int j,int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
