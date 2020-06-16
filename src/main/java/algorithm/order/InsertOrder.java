package algorithm.order;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 插入排序
 * 将第一个看成有序的，依次将后面的元素插入
 */
public class InsertOrder {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,56,2,9,4,5,45,76,23,44};
        for (int i = 1;i<a.length;i++){
            for(int j =i;j>0;j--){
                if(a[j]<a[j-1]){
                    swap(j,j-1 ,a );
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
