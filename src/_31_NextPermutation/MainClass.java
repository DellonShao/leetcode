package _31_NextPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
//    public void nextPermutation(int[] nums) {
////        if(nums.length <= 1) return;
////        boolean seq = true;
////        for(int i = 0; i < nums.length - 1; ++i){
////            if(nums[i] > nums[i + 1]) seq = false;//不是顺序
////        }
////        //顺序
////        if(seq == true){
////            int tmp = nums[nums.length - 2];
////            nums[nums.length - 2] = nums[nums.length - 1];
////            nums[nums.length - 1] = tmp;
////            return;
////        }
////        //存在逆序,判断序列是全逆序的
////        seq = true;
////        for(int i = nums.length - 1; i > 0; --i){
////            if(nums[i] > nums[i - 1]){
////                seq = false;
////                //二分查找
////                int low = i, high = nums.length - 1;
////                while(low <= high){
////                    int mid = (low + high) / 2;
////                    if(nums[mid] > nums[i - 1]){
////                        low = mid + 1;
////                    }else{
////                        high = mid - 1;
////                    }
////                }
////                nums[high] = nums[i - 1] + nums[high];
////                nums[i - 1] = nums[high] - nums[i - 1];
////                nums[high] = nums[high] - nums[i - 1];
////                reverse(i, nums.length - 1, nums);
////                return;
////            };
////        }
////        //全部是逆序
////        if(seq == true){
////            reverse(0, nums.length - 1, nums);
////        }
////    }
////
////    private void reverse(int start, int end, int[] nums){
////        int mid = (start + end + 1) / 2;
////        for(int i = start; i < mid; ++i) {
////            nums[i] = nums[i] + nums[end + start - i];
////            nums[end + start - i] = nums[i] - nums[end + start - i];
////            nums[i] = nums[i] - nums[end + start - i];
////        }
////    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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

            new Solution().nextPermutation(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}