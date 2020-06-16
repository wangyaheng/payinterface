package leetcode.order;

/**
 * 希尔排序
 * 插入排序的改进 步长分组
 *
 */
public class ShellOrder {
    public static void main(String[] args) {
        int data[] = {45, 28, 80, 90, 50, 16, 100, 10};
        int step = data.length;
        while(step>=1){
            step = step/2;
            for(int i=step;i<data.length;i++){
                for(int j=i;j-step>0;j-=step){
                    if(data[j]<data[j-step]){
                        int temp = data[j];
                        data[j] = data[j - step];
                        data[j - step] = temp;
                    }else{
                        break;
                    }

                }
            }
        }
    }
}
