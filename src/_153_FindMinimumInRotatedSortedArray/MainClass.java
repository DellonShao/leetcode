package _153_FindMinimumInRotatedSortedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= nums[low] && nums[mid] > nums[high]){//左边有序
                low = mid + 1;
            }else if(nums[mid] >= nums[low] && nums[mid] <= nums[high]){
                return nums[low];
            }else{
                high = mid;
            }
        }
        return nums[low];
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution().findMin(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}