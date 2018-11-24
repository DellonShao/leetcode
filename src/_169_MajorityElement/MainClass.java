package _169_MajorityElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int majority = 0;
        int counter = 0;
        for(int num : nums){
            if(counter == 0) {
                majority = num;
                counter++;
            }
            else{
                if(majority == num){
                    counter++;
                }else
                    counter--;
            }
        }
        //已知必存在众数
//        counter = 0;
//        for(int num : nums){
//            if(majority == num) counter++;
//        }
//        if(counter > nums.length / 2)
//            return majority;
//
//        return -1;
        return majority;
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

            int ret = new Solution().majorityElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}