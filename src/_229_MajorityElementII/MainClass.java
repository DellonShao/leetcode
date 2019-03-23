package _229_MajorityElementII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //摩尔投票法,对于n/3，至多有两个候选人
        int candidate1 = 0, candidate2 = 0, cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < nums.length; ++i){
            if(candidate1 == nums[i]){
                cnt1++;
            }else if(candidate2 == nums[i]){
                cnt2++;
            }else if(cnt1 == 0){
                cnt1++;
                candidate1 = nums[i];
            }else if(cnt2 == 0){
                cnt2++;
                candidate2 = nums[i];
            }else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        cnt1 = 0;cnt2 = 0;
        //对候选人进行筛选
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == candidate1) cnt1++;
            else if(nums[i] == candidate2) cnt2++;
        }
        if(cnt1 > nums.length / 3) result.add(candidate1);
        if(cnt2 > nums.length / 3) result.add(candidate2);
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Solution().majorityElement(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}