package _55_JumpGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean canJump(int[] nums) {
//        if(nums.length == 0) return true;
//        int pos = nums.length - 1;
//        boolean isReachable = true;
//        while(isReachable) {
//            if(pos == 0) break;
//            isReachable = false;
//            //寻找能到达这个点的位置
//            int k;
//            for (k = pos - 1; k >= 0; --k) {
//                if(nums[k] >= pos - k){
//                    isReachable = true;
//                    break;
//                }
//            }
//            pos = k;
//        }
//        return isReachable;
        //简化
        int cnt = 0;
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] > cnt){
                cnt = 0;
            }else cnt++;
        }
        return cnt == 0;
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

            boolean ret = new Solution().canJump(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}