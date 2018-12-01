package _33_SearchInRotatedSortedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        //二分，确定target在的半区
        while(low < high){
            mid = (low + high) >> 1;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[low]){//在左半区有序
                if(nums[mid] > target && target >= nums[low]){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }else{//在右半区
                if(nums[mid] < target && target <= nums[high - 1]){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        return -1;
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution().search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}