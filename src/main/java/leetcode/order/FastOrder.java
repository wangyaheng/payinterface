package leetcode.order;

/**
 * ��������NlogN��ʱ�临�Ӷȣ���
 * �ݹ� �һ�׼��
 */
public class FastOrder {
    public static void main(String[] args) {
        int data[] = { 45, 28, 80, 90, 50, 16, 100, 10 };
        qsort(data, 0, data.length - 1);
        print(data);

    }

    public static void qsort(int[] data,int left,int right){
        int ll = left;// ������ҵ�λ��
        int rr = right;// ���ұ��ҵ�λ��
        int basic = data[left];// ��׼��

        while(ll<rr){
            // �Ӻ����ұȻ�׼��С����
            while(ll<rr&&data[rr]>=basic){
                rr--;
            }
            if(ll<rr){
                // ����λ��
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
        System.out.println("��Base=" +basic+ "��������");
        print(data);
        // �Ի�׼����Ϊ3���֣���ߵı�֮С���ұ߱�֮�� ����Ҫ���ľ���һ������ߺ��ұ߷ֱ���п�������
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
