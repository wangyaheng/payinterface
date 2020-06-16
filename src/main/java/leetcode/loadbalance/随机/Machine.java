package leetcode.loadbalance.随机;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {

    public static final List<String> machineList = new ArrayList<>();
    public static final Map<String,Integer> machineMap = new HashMap<>();

    public static void main(String[] args) {

        RandomBalance randomBalance = new RandomBalance();
       for (int i=0;i<10;i++) {
           System.out.println(randomBalance.getMachineWeightRandom());
       }
    }

    static{
        machineList.add("192.168.1.1");
        machineList.add("192.168.1.2");
        machineList.add("192.168.1.3");
        machineList.add("192.168.1.4");
        machineList.add("192.168.1.5");
        machineList.add("192.168.1.6");
        machineList.add("192.168.1.7");
        machineList.add("192.168.1.8");


        machineMap.put("192.168.1.1",1);
        machineMap.put("192.168.1.2",8);
        machineMap.put("192.168.1.3",3);
        machineMap.put("192.168.1.4",4);
        machineMap.put("192.168.1.5",7);
        machineMap.put("192.168.1.6",10);
        machineMap.put("192.168.1.7",15);
        machineMap.put("192.168.1.8",2);
        machineMap.put("192.168.1.9",30);
    }
}
