package _49_GroupAnagrams;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        HashMap<Integer, List<String>> map = new HashMap<>();
//
//        for(String str : strs){
//            int num = 1;
//            for(int j = 0; j < str.length(); ++j){
//                num *= str.charAt(j) - 'a' + 1;
//            }
//            if(map.containsKey(num)){
//                map.get(num).add(str);
//            }else{
//                List<String> tmp = new ArrayList<>();
//                tmp.add(str);
//                map.put(num, tmp);
//            }
//        }
//
//        for(int key : map.keySet()){
//            result.add(map.get(key));
//        }


        List<List<String>> result = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();

        for(String str : strs){
            int tmp = 0;
            for(int i = 0; i < str.length();++i){
                tmp ^= str.charAt(i) - 'a' + 1;
            }
            if(map.containsKey(tmp)){
                map.get(tmp).add(str);
            }else{
                List<String> alist = new ArrayList<>();
                alist.add(str);
                map.put(tmp, alist);
            }
        }
        for(int key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}

public class MainClass {
}
