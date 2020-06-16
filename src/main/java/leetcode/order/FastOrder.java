package leetcode.order;

/**
 * 快速排序（NlogN（时间复杂度））
 * 递归 找基准数
 */
public class FastOrder {
    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };
        qsort(data, 0, data.length - 1);
        print(data);

    }

    public static void qsort(int[] data,int left,int right){
        int ll = left;// 从左边找的位置
        int rr = right;// 从右边找的位置
        int basic = data[left];// 基准数

        while(ll<rr){
            // 从后面找比基准数小的数
            while(ll<rr&&data[rr]>=basic){
                rr--;
            }
            if(ll<rr){
                // 交换位置
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }
            while(ll<rr&&data[ll]<=basic){
               ll++;
            }
            if(ll<rr){
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;
            }
        }
        System.out.println("以Base=" +basic+ "的排序结果");
        print(data);
        // 以基准数分为3部分，左边的比之小，右边比之大 我们要做的就是一把这左边和右边分别进行快速排序
        if (ll > left) {
            qsort(data, left, ll - 1);
        }
        if (rr < right) {
            qsort(data, ll+1, right);
        }

    }
    public static void print(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
