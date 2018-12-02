package _40_CombinationSumII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0 && target < 0) return result;
        Arrays.sort(candidates);
        LinkedList<Integer> cur = new LinkedList<>();
        dfs(candidates, target, result, cur, -1, -1);

        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, LinkedList<Integer> cur, int index, int remove){
        if(target == 0){
            Object tmp = cur.clone();
            //if(!result.contains(tmp))
            result.add((LinkedList<Integer>)tmp);
            return;
        }else if(target < 0){
            return;
        }

        for(int i = index + 1; i < candidates.length; ++i){
            if(remove == candidates[i]) continue;
            target -= candidates[i];
            cur.add(candidates[i]);
            dfs(candidates, target, result, cur, i, -1);
            remove = cur.removeLast();
            target += candidates[i];
        }
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

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
            int[] candidates = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().combinationSum2(candidates, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}