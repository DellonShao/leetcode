package _77_Combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < k) return result;
        dfs(n, k, 0, 0,new LinkedList<Integer>(), result);

        return result;
    }

    private void dfs(int n, int k, int index, int cnt, LinkedList<Integer> ele, List<List<Integer>> result){
        if(cnt == k){
            result.add((List<Integer>)ele.clone());
            return;
        }
        if(index >= n) return;
        dfs(n, k, index + 1, cnt, ele, result);
        ele.addLast(index + 1);
        dfs(n, k, index + 1, cnt + 1, ele, result);
        ele.removeLast();
    }
}

public class MainClass {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().combine(n, k);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}