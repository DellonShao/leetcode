package _300_LongestIncreasingSubsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int lengthOfLIS(int[] nums) {
        //O(n^2)的算法
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int i = 1; i < nums.length;++i){
            int max = 0;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            if(dp[i] > result) result = dp[i];
        }
        return result;
    }
    public int lengthOfLIS1(int[] nums) {
        //dp[i] 为i+ 1长度LIS的尾数，可知dp是递增的
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxL = 0;//最长的序列长，二分边界
        for(int num : nums){
            int l = 0, h = maxL;
            while(l < h){
                int mid = l + (h - l) / 2;
                if(dp[mid] < num){
                    l = mid + 1;
                }else{
                    h = mid;
                }
            }
            dp[l] = num;
            //更新dp的边界
            if(l == maxL) maxL++;
        }
        return maxL;
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

            int ret = new Solution().lengthOfLIS1(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}