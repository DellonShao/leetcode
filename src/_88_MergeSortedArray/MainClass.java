package _88_MergeSortedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //插入排序
//        if(m == 0){
//            int i = 0;
//            for(int aNum : nums2){
//                nums1[i++] = aNum;
//            }
//            return;
//        }
//        for(int i = 0; i < n; ++i){
//            for(int j = i + m - 1; j >= 0; --j){
//                if(nums1[j]>nums2[i]){
//                    nums1[j + 1] = nums1[j];
//                    if(j == 0) nums1[0] = nums2[i];
//                }else{
//                    nums1[j + 1] = nums2[i];
//                    break;
//                }
//            }
//        }

        //类似冒泡排序
        for(int i = 0; i < n; ++i){
            nums1[i + m] = nums2[i];
        }
        for(int i = m; i < m + n; ++i){
            int j = i;
            for(; j > 0 && nums1[j] < nums1[j - 1]; --j){
                int temp = nums1[j];
                nums1[j] = nums1[j - 1];
                nums1[j - 1] = temp;
            }
            if(j == i) break;
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
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            new Solution().merge(nums1, m, nums2, n);
            String out = integerArrayToString(nums1);

            System.out.print(out);
        }
    }
}