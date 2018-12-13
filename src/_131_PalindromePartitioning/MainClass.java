package _131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length() == 0) {
            result.add(new LinkedList<>());
            return result;
        }
        dfs(s, 0, result, new LinkedList<>());
        return result;
    }

    private void dfs(String s, int index, List<List<String>> result, LinkedList<String> ele){
        if(index == s.length()){
            result.add((List<String>)ele.clone());
            return;
        }

        for(int i = index; i < s.length(); ++i){
            String tmp = s.substring(index, i + 1);
            StringBuilder sb = new StringBuilder(tmp);
            if(tmp.equals(sb.reverse().toString())){
                ele.addLast(tmp);
                dfs(s, i + 1, result, ele);
                ele.removeLast();
            }
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(s.partition("aab"));
    }
}
