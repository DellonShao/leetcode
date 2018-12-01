package _34_FindFirstAndLastPositionOfElementInSortedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //binary search
        int[] result = new int[2];
        int low = 0, high = nums.length, mid;
        boolean exit = false;
        while (low < high) {
            mid = low + (high - low >> 1);//防止溢出
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] == target) {
                high = mid;
                exit = true;
            } else {
                high = mid;
            }
        }
        if (!exit) {
            return new int[]{-1, -1};
        }
        result[0] = low;
        high = nums.length;
        while (low < high) {
            mid = low + (high - low >> 1);//防止溢出
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        result[1] = high - 1;
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new Solution().searchRange(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}