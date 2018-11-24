package _189_RotateArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void rotate(int[] nums, int k) {
        //数组反转
        if(k >= nums.length){
            k = k % nums.length;
        }
        int pre = (nums.length - k) / 2;
        for(int i = 0; i < pre; ++i){
            int temp = nums[i];
            nums[i] = nums[nums.length - k - i - 1];
            nums[nums.length - k - i - 1] = temp;
        }
        for(int i = 0; i < k / 2; ++i){
            int temp = nums[nums.length - k + i];
            nums[nums.length - k + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        for(int i = 0; i < nums.length / 2; ++i){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        return;
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
            line = in.readLine();
            int k = Integer.parseInt(line);

            new Solution().rotate(nums, k);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}