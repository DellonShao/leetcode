package _152_MaximumProductSubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxProduct(int[] nums) {

        //乘上一个数之后，要么是最大，要么最小，要么是0
//        int len = nums.length;
//        if(len == 0) return 0;
//        int dp, nmax, nmin;
//        dp = nmax = nmin = nums[0];
//        for(int i = 1; i < len; ++i){
//            if(nums[i] >= 0){
//                nmax = Math.max(nmax * nums[i], nums[i]);
//                nmin = Math.min(nmin * nums[i], nums[i]);
//            }else{
//                int tmp = nmax;
//                nmax = Math.max(nmin * nums[i], nums[i]);
//                nmin = Math.min(tmp * nums[i], nums[i]);
//            }
//            dp = Math.max(nmax, dp);
//        }
//
//        return dp;
        int max = nums[0];
        int min = nums[0];
        int maxres = max;

        for(int i=1;i<nums.length;i++){
            int tmp1 = max * nums[i];
            int tmp2 = min * nums[i];
            max = Math.max(nums[i], Math.max(tmp1, tmp2));
            min = Math.min(nums[i], Math.min(tmp1, tmp2));

            maxres = Math.max(maxres, max);
        }

        return maxres;
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

            int ret = new Solution().maxProduct(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}