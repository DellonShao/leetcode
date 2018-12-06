package _80_RemoveDuplicatesFromSortedArrayII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0) return 0;
//        int cnt = 0;
//        int p = -1;//尾指针
//        int pre = nums[0];
//        for(int i = 0; i < nums.length; ++i){
//            if(pre == nums[i]){
//                cnt++;
//                if(cnt <= 2)
//                    nums[++p] = nums[i];
//            }else{
//                cnt = 1;
//                pre = nums[i];
//                nums[++p] = nums[i];
//            }
//        }
//        return p + 1;

        //更好的做法，可重复两项，和上上个位置的值[如果存在的话]比较，如果相同就删除，不同则保留
        int p = 0;//尾指针
        for(int num : nums){
            if(p < 2 || num > nums[p - 2])
                nums[p++] = num;
        }

        return p;
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

            int ret = new Solution().removeDuplicates(nums);
            String out = integerArrayToString(nums, ret);

            System.out.print(out);
        }
    }
}