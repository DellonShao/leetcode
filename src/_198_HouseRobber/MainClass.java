package _198_HouseRobber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
//    public int rob(int[] nums) {
//        int len = nums.length - 1;
//        if(len < 0) return 0;
//        int fn1 = robNum(nums, len - 1);
//        int fn2 = robNum(nums, len - 2) + nums[len];
//        int fn3 = robNum(nums, len - 3) + nums[len];
//        int result = Math.max(Math.max(fn1,fn2), fn3);
//        return result;
//    }
//
//    public int robNum(int[] nums, int index){
//        if(index < 0) return 0;
//        //int len = nums.length - 1;
//        int fn1 = robNum(nums, index - 1);
//        int fn2 = robNum(nums, index - 2) + nums[index];
//        int fn3 = robNum(nums, index - 3) + nums[index];
//        return Math.max(Math.max(fn1,fn2), fn3);
//    }

    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];//表示到i位置，不相邻和最大
//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//        for(int i = 0; i < nums.length; ++i){
//            dp[i] = Math.max(i - 2 >= 0 ? dp[i - 2] : 0, i - 3 >= 0 ? dp[i - 3] : 0) + nums[i];
//        }
//
//        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);

        //上述方法还可以进一步简洁，我们使用两个变量rob和notRob，
        // 其中rob表示抢当前的房子，notRob表示不抢当前的房子，那么在遍历的过程中，
        // 我们先用两个变量preRob和preNotRob来分别记录更新之前的值，由于rob是要抢当前的房子，
        // 由于抢了当前的房子，那么前一个房子一定不能抢，所以使用preNotRob加上当前的数字赋给rob，
        // 然后notRob表示不能抢当前的房子，那么之前的房子就可以抢也可以不抢，所以我们将preRob和preNotRob中的较大值赋给notRob
        int rob = 0, notRob = 0, n = nums.length;
        for(int i = 0; i < n; ++i){
            int preRob = rob, preNotRob = notRob;
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
        }
        return Math.max(rob, notRob);
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

            int ret = new Solution().rob(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}