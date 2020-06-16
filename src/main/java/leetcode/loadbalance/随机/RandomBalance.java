package leetcode.loadbalance.随机;

import java.util.Random;

public class RandomBalance {

    public String getMachine(){
        Random random = new Random();
        int i = random.nextInt(Machine.machineList.size());
        return Machine.machineList.get(i);

    }

    public String getMachineWeightRandom(){
        // 获取总权重
        Integer integer = Machine.machineMap.values().stream().reduce((a, b) -> a + b).get();
        Random random = new Random();
        int i = random.nextInt(integer);

        // 判断落在那个区间内
        for (String s : Machine.machineMap.keySet()) {

            Integer weight = Machine.machineMap.get(s);
            if(i<weight){
                return s;
            }
            i=i-weight;

        }

        return null;
    }
}
