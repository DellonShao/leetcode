package _47_PermutationsII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int watch = Integer.MIN_VALUE;
        dfs(nums, result, 0, new LinkedList<>(), watch);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int index, LinkedList<Integer> ele, int watch){
        if(index == nums.length){
            result.add((List<Integer>) ele.clone());
            return;
        }
        int visited = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != watch && visited != nums[i]) {
                visited = nums[i];
                ele.addLast(nums[i]);
                int tmp = nums[i];
                nums[i] = watch;
                dfs(nums, result, index + 1, ele, watch);
                nums[i] = tmp;
                ele.removeLast();
            }
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
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().permuteUnique(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}