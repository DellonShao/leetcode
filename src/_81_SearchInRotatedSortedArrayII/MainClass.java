package _81_SearchInRotatedSortedArrayII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean search(int[] nums, int target) {

        int low = 0, high = nums.length;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] > nums[low]){//左半边有序
                if(target >= nums[low] && target < nums[mid]){
                    high = mid;
                }else low = mid + 1;
            }else if(nums[mid] == nums[low]){
                low++;
            }
            else { //在右半区
                if(target <= nums[high - 1] && target > nums[mid]){
                    low = mid + 1;
                }else high = mid;
            }
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            boolean ret = new Solution().search(nums, target);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}