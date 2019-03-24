package _238_ProductOfArrayExceptSelf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        //走两遍，等于前缀积与后缀积的乘积
        if(nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for(int i = 1; i < nums.length; ++i){
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            result[i] = result[i] * right;
            right *= nums[i];
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int[] ret = new Solution().productExceptSelf(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}