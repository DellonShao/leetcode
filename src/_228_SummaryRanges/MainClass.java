package _228_SummaryRanges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        int preLeft = nums[0], pre = nums[0], cur = nums[0];
        for(int i = 1; i < nums.length; ++i){
            cur = nums[i];
            if(cur > pre + 1){//断层
                String tmp;
                if(preLeft == pre) tmp = String.valueOf(preLeft);
                else tmp = preLeft + "->" + pre;
                result.add(tmp);
                preLeft = cur;
                pre = cur;
            }else{
                pre = cur;
            }
        }
        String tmp;
        if(preLeft == pre) tmp = String.valueOf(preLeft);
        else tmp = preLeft + "->" + pre;
        result.add(tmp);
        return result;
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

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<String> ret = new Solution().summaryRanges(nums);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}