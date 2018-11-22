package _27_RemoveElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    //double pointer
    public int removeElement(int[] nums, int val) {
//        if(nums.length == 0) return 0;
//        int p1 = 0, p2 = nums.length - 1;
//
//        while(p1 <= p2){
//            while(p1 < nums.length && nums[p1] != val) p1++;
//            while(p2 > -1 && nums[p2] == val) p2--;
//            if(p1 < p2){
//                int temp = nums[p1];
//                nums[p1] = nums[p2];
//                nums[p2] = temp;
//            }
//        }
//        return p1;
        int i = 0;
        for(int j = 0; j < nums.length; ++j){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
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
            int val = Integer.parseInt(line);

            int ret = new Solution().removeElement(nums, val);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}
