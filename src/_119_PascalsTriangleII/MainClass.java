package _119_PascalsTriangleII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        for(int i = 0; i <= rowIndex; ++i){
//            List<Integer> aList = new ArrayList<>();
//            aList.add(1);
//            int mid = i / 2;
//            for(int j = 1; j <= mid; ++j) {
//                int aNum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
//                aList.add(aNum);
//            }
//            //复制另一半
//            for(int j = mid + 1; j <= i; ++j){
//                aList.add(aList.get(i - j));
//            }
//            result.add(aList);
//        }
//        return result.get(rowIndex);
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        int m = rowIndex, n = 1;
        long pre = 1;
        for(int i = 1; i <= rowIndex; ++i){
            pre = pre * m / n;
            aList.add((int)pre);
            m--;
            n++;
        }
        return aList;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int rowIndex = Integer.parseInt(line);

            List<Integer> ret = new Solution().getRow(rowIndex);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
