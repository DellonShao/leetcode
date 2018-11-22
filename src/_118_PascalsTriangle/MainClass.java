package _118_PascalsTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; ++i){
            List<Integer> aList = new ArrayList<>();
            aList.add(1);
            int mid = i / 2;
            for(int j = 1; j <= mid; ++j) {
                int aNum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                aList.add(aNum);
            }
            //复制另一半
            for(int j = mid + 1; j <= i; ++j){
                aList.add(aList.get(i - j));
            }
            result.add(aList);
        }
        return result;
    }
}

public class MainClass {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numRows = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution().generate(numRows);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}