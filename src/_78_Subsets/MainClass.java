package _78_Subsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        LinkedList<Integer> cur = new LinkedList<>();
//        dfs(nums, result, cur, 0);
//        return result;
//    }
//
//    private void dfs(int[] nums, List<List<Integer>> result, LinkedList<Integer> cur, int index){
//        if(index == nums.length){
//            Object tmp = cur.clone();
//            result.add((LinkedList<Integer>) tmp);
//            return;
//        }
//        //不加
//        dfs(nums, result, cur, index + 1);
//        //加
//        cur.add(nums[index]);
//        dfs(nums, result, cur, index + 1);
//        cur.removeLast();
//    }
    //位运算
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int cnt = (int) (Math.pow(2, nums.length) - 1);
        int symbol = 0;
        for(int i = 0; i <= cnt; ++i){
            symbol = i;
            for(int j = 0; j < nums.length; ++j){
                if((symbol & 1) == 1){
                    tmp.add(nums[j]);
                }
                symbol >>= 1;
            }
            result.add(tmp);
            tmp = new ArrayList<>();
        }
        return result;
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

            List<List<Integer>> ret = new Solution().subsets(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}