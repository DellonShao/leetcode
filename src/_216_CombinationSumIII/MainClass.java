package _216_CombinationSumIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //深度遍历
        List<List<Integer>> result = new ArrayList<>();
        if(k == 0){
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> line = new LinkedList<>();
        for(int i = 1; i <= 9; ++i){
            line.add(i);
            dfs(result, line, i, n, k);
            ((LinkedList<Integer>) line).removeLast();
        }

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> line, int sum, int n, int k){
        if(sum == n && line.size() == k){
            result.add((List<Integer>) ((LinkedList)line).clone());
            return;
        }else if(sum > n || line.size() > k) return;

        for(int i = ((LinkedList<Integer>)line).getLast() + 1; i <= 9; ++i){
            line.add(i);
            dfs(result, line, sum + i, n, k);
            ((LinkedList<Integer>) line).removeLast();
        }
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
            int k = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().combinationSum3(k, n);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}