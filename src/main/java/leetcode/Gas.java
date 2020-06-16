package leetcode;



/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[ i ]，并且从第 i 个加油站前往第 i+1 个加油站需要消耗汽油cost[ i ]。
 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
 写一个函数求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 */
public class Gas {


    public static void main(String[] args) {
        int[] gas = new int[]{1, 1, 3, 1};
        int[] cost = new int[]{2, 2, 1, 1};

        int remainGas  = 0;
        int startIndex = -1;
        for(int i = 0;i<gas.length;i++){
            remainGas += gas[i]-cost[i];
            if(remainGas>=0){
                // 可以继续走
                if(startIndex==-1){
                    // 更新起点
                    startIndex = i;
                }

            }else{
                startIndex = -1;
            }
        }
        if(remainGas<0){
            System.out.println(-1);
        }else{
            System.out.println(startIndex);
        }

    }
}
