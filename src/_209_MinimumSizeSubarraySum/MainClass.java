package _209_MinimumSizeSubarraySum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //双指针
        int left = 0, right = 0, sum = 0;
        int result = Integer.MAX_VALUE;
        while(right < nums.length){
            while(sum < s && right != nums.length) {
                //if(right == nums.length) break;
                sum += nums[right++];//不够，右指针走
            }
            while(sum >= s){
                if(result > right-left) result = right-left;
                sum -= nums[left++];//够了，左指针走
            }
        }

        return result == Integer.MAX_VALUE?0:result;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int s = Integer.parseInt(line);
            line = in.readLine();
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().minSubArrayLen(s, nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}