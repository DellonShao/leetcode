package _75_SortColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void sortColors(int[] nums) {
        //双指针
        int low = 0, high = nums.length - 1;
        int i = 0;
        while(i <= high){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[low];
                nums[low] = tmp;
                ++low; ++i;
            }else if(nums[i] == 1){
                ++i;
            }else if(i <= high && nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[high];
                nums[high] = tmp;
                --high;
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

            new Solution().sortColors(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}
