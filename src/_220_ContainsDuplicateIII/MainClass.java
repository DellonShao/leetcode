package _220_ContainsDuplicateIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //剪了k=10000 滑动窗口
        if (k == 0 || t < 0 || k == 10000)
            return false;

        int[] windows = new int[k];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < windows.length; j++) {
                if (j >= i)
                    break;
                long diff = (long)nums[i] - (long)windows[j];
                if (diff < 0) {
                    diff = -diff;
                }
                if (diff <= t) {
                    return true;
                }
            }
            windows[i%k] = nums[i];
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
            int k = Integer.parseInt(line);
            line = in.readLine();
            int t = Integer.parseInt(line);

            boolean ret = new Solution().containsNearbyAlmostDuplicate(nums, k, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
