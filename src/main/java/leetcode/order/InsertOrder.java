package leetcode.order;


/**
 * 插入排序
 * 先办第一个元素当作有序，后面的数一次进来，插入到之前的有序的数组中
 */
public class InsertOrder {

    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };
        for(int i = 1;i<data.length;i++){
            for(int j=i;j>0;j--){
                if(data[j]<data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
        System.out.println(data);
    }


}
