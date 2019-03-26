package _287_FindtheDuplicateNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int findDuplicate(int[] nums) {
        //快慢指针
        int slow = nums[0], fast = nums[0];
        //找到相遇节点
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        //起始节点与相遇节点同时同步长走，相遇的节点即为入口
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
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

            int ret = new Solution().findDuplicate(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}