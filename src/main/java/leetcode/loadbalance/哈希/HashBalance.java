package leetcode.loadbalance.哈希;

import leetcode.loadbalance.随机.Machine;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法
 */
public class HashBalance {

    private static final SortedMap<Integer,String> virtualNode = new TreeMap<>();

    private static final int NODE_COUNT = 80;
    public static void main(String[] args) {
        System.out.println(Hash("123"));
    }

    static {
        // 初始化虚拟节点
        for (int i =0;i< Machine.machineList.size();i++) {
            for(int j=0;j<NODE_COUNT;j++){
                Integer hash = Hash( Machine.machineList.get(i)+ "VN" + j);
                virtualNode.put(hash, Machine.machineList.get(i));
            }


        }
    }

    public String getMachine(String client) {
        Integer hash = Hash(client);
        SortedMap<Integer, String> integerStringSortedMap = virtualNode.tailMap(hash);
        Integer integer = integerStringSortedMap.firstKey();
        if(integer==null){
            integer = virtualNode.firstKey();
        }


        return virtualNode.get(integer);
    }

    private static Integer Hash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) hash = Math.abs(hash);
        return hash;
    }


}
