package _241_DifferentWaystoAddParentheses;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //分治算法
        List<Integer> list = new ArrayList<>();
        if(input.length() == 0) return list;
        boolean flag = false;
        for(int i = 0; i < input.length(); ++i){
            if(Character.isDigit(input.charAt(i))) continue;
            flag = true;
            List<Integer> lList = diffWaysToCompute(input.substring(0,i));
            List<Integer> rList = diffWaysToCompute(input.substring(i+1,input.length()));
            for(int m : lList){
                for(int n : rList){
                    char op = input.charAt(i);
                    int result = 0;
                    switch (op){
                        case '+': result = m + n;break;
                        case '-': result = m - n;break;
                        case '*': result = m * n;break;
                    }
                    list.add(result);
                }
            }
        }
        if(flag == false) list.add(Integer.parseInt(input));

        return list;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

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
            String input = stringToString(line);
            List<Integer> ret = new Solution().diffWaysToCompute(input);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}