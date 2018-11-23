package _167_TwoSumII_InputArrayisSorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
//        int[] result = new int[2];
//        for(int i = 0; i < numbers.length && numbers[i] < target / 2 + 1; ++i){
//            int low = i + 1, high = numbers.length;
//            int temp = target - numbers[i];
//            while(low < high){
//                int mid = (low + high) / 2;
//                if(numbers[mid] == temp){
//                    result[0] = i + 1;
//                    result[1] = mid + 1;
//                    return result;
//                }else if(numbers[mid] > temp){
//                    high = mid;
//                }else{
//                    low = mid;
//                }
//            }
//        }
//        return result;

        //双指针
        int p1 = 0, p2 = numbers.length - 1;
        int[] result = new int[2];
        while(p1 < p2){
            while(numbers[p1] + numbers[p2] > target) p2--;
            if(numbers[p1] + numbers[p2] == target){
                result[0] = p1 + 1;
                result[1] = p2 + 1;
                return result;
            }
            while(numbers[p1] + numbers[p2] < target) p1++;
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
            int[] numbers = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution().twoSum(numbers, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}