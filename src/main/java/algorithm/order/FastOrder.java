package algorithm.order;

import com.lefu.commons.utils.lang.JsonUtils;

/**
 * 快速排序
 * 找到基准数 以基准数为准 小于的放到基准数左边  大于的放到基准数右边
 * 递归循环上面的操作
 */
public class FastOrder {
    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };
        qSort(data, 0, data.length-1);
        int result = 0;
        for (int i = 1; i < data.length; i++) {
            result = Math.max(data[i]-data[i-1],result );
        }
        System.out.println(result);
    }

    public static void qSort(int[] data,int left,int right){
        // 找到基准数
        int baseNum = data[left];
        int ll = left;
        int rr = right;
        // 将小于基准数的放到基准数左边，大于基准数的放到基准数的右边
        while(ll<rr){
            //基准数在左边  所以要先从右边开始找比基准数小的数 交换
            while(ll<rr&&data[rr]>baseNum){
                rr--;
            }
            // 交换数据
            swap(ll, rr, data);
            while(ll<rr&&data[ll]<baseNum){
                ll++;
            }
            swap(ll, rr, data);
        }
        System.out.println("baseNum:"+ baseNum+"  "+ JsonUtils.toJsonString(data));
        if(ll>left){
            qSort(data,left,ll-1);
        }
        if(rr<right){
            qSort(data,ll+1,right);
        }


    }
    public static void swap(int i,int j,int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
