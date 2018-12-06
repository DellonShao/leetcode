package _162_FindPeakElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int findPeakElement(int[] nums) {
        //log(n)时间复杂度
        //看复杂度用的应该是二分法
//        if(nums.length == 1) return 0;
//        int low = 0, high = nums.length;
//        while(low < high){
//            int mid = (low + high - 1) >> 1;
//            //判断中间的是否是峰值
//            if(mid == 0){
//                if(nums[mid] > nums[mid + 1])
//                    return mid;
//                else low = mid + 1;
//            }else if(mid == nums.length - 1){
//                if(nums[mid] > nums[mid - 1])
//                    return mid;
//                else high = mid;
//            }else{
//                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
//                    return mid;
//                }else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
//                    low = mid + 1;
//                }else if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
//                    high = mid;
//                }else{
//                    low = mid + 1;
//                }
//            }
//        }
//        return low;

        //简单的写法

        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
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

            int ret = new Solution().findPeakElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}