package leetcode;



import java.util.HashMap;
import java.util.Map;


/**
 * 罗马数字转整数
 */
public class Q13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int sum = 0;

        while (s.length()>0){
            if(s.length()==1) return sum+=map.get(s);
            String substring = s.substring(0, 2);
            if(map.get(substring)!=null){
                sum+=map.get(substring);
                s = s.substring(2, s.length());
            }else{
                sum+=map.get(s.substring(0,1 ));
                s = s.substring(1, s.length());
            }
        }


        return sum;


    }
}
