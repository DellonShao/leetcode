package _260_SingleNumberIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int tmp = 0;
        for(int i = 0; i < nums.length; ++i){
            tmp ^= nums[i];
        }
        //根据tmp找出a,b的不同，分别对不同性质进行异或，就可以得到最终的数
        int diff = 1;
        while((diff & tmp) == 0){
            diff <<= 1;
        }
        for(int num : nums){
            if((num & diff) == 0){
                result[0] ^= num;
            }else{
                result[1] ^= num;
            }
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

            int[] ret = new Solution().singleNumber(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}