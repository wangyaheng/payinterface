package leetcode;

import org.apache.poi.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 2:abc
 3,def
 4,ghi
 5,jkl
 6,mno
 7,pqrs
 8,tuv
 9,wxyz
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Q17 {
    public static void main(String[] args) {
        List<String> strings = letterCombinations("2");

    }
    public static List<String> letterCombinations(String digits) {
        digits = digits.trim();
        List<String> result = new ArrayList<>();
        if(digits.length()==0)return result;
        Map<Integer,String[]> map= new HashMap<>();
        map.put(2,new String []{"a","b","c"});
        map.put(3,new String []{"d","e","f"});
        map.put(4,new String []{"g","h","i"});
        map.put(5,new String []{"j","k","l"});
        map.put(6,new String []{"m","n","o"});
        map.put(7,new String []{"p","q","r","s"});
        map.put(8,new String []{"t","u","v"});
        map.put(9,new String []{"w","x","y","z"});

        int[] arr = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            arr[i] = Integer.parseInt(digits.substring(i, i + 1));//substring是找出包含起始位置，不包含结束位置，到结束位置的前一位的子串
        }

        backtrace(0, result, arr,new StringBuilder() ,map );
        System.out.println(result);
        return result;
    }

    public static void backtrace(int numIndex,List<String> result,int[] nums,StringBuilder temp,Map<Integer,String[]> cacheMap){
        if(numIndex>=nums.length){
            result.add(temp.toString());
        } else{
            int tempIndex = numIndex>nums.length-1?nums.length-1:numIndex;
            for(int i = 0;i<cacheMap.get(nums[tempIndex]).length;i++){
                temp.append(cacheMap.get(nums[tempIndex])[i]);
                //if(i==0&&nums[tempIndex]!=nums[nums.length-1])
                    backtrace(numIndex+1,result ,nums,temp,cacheMap);
               /* else{
                    backtrace(nums.length-1,result ,nums,temp,cacheMap);
                }*/
                temp.deleteCharAt(temp.length()-1);

            }

        }

    }
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();


    /**
     * 官方解题
     * @param combination
     * @param next_digits
     */
    public void backtrack1(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack1(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0)
            backtrack1("", digits);
        return output;
    }



}
