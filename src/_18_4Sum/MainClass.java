package _18_4Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //转化成3数之和
        //想固定其中一个值
        List<List<Integer>> aList = new LinkedList<>();
        int len = nums.length, i = 0;
        if(len < 4) return aList;
        Arrays.sort(nums);
        while(i < len - 3){
            //加一些判断提前结束循环
            int j = i + 1;
            int sum2 = nums[j] + nums[i];
            while(j < len - 2){
                //加一些判断提前结束循环
                int m = j + 1, n = len - 1;
                while(m < n){
                    if(sum2 + nums[m] + nums[n] == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[m]);temp.add(nums[n]);
                        aList.add(temp);
                        while(m < len - 1 && nums[m] == nums[++m]){}
                        while(n > 0 && nums[n] == nums[--n]){}
                    }else if(sum2 + nums[m] + nums[n] < target){
                        ++m;
                    }else
                        --n;
                }
                while(j < len - 1 && nums[j] == nums[++j]){}
                sum2 = nums[j] + nums[i];
            }
            while(i < len - 1 && nums[i] == nums[++i]){}
        }

        return aList;
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().fourSum(nums, target);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
