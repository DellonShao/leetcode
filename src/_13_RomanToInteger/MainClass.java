package _13_RomanToInteger;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> numMap = new HashMap<>();

        numMap.put('I', 1);
        numMap.put('V',5);
        numMap.put('X',10);
        numMap.put('L',50);
        numMap.put('C',100);
        numMap.put('D',500);
        numMap.put('M',1000);

        int result = 0;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    if(i != s.length() - 1){
                        if(s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'){
                            result -= numMap.get(c);
                        }else{
                            result += numMap.get(c);
                        }
                    }
                    break;
                case 'X':
                    if(i != s.length() - 1){
                        if(s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'){
                            result -= numMap.get(c);
                        }else{
                            result += numMap.get(c);
                        }
                    }
                    break;
                case 'C':
                    if(i != s.length() - 1){
                        if(s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'){
                            result -= numMap.get(c);
                        }else{
                            result += numMap.get(c);
                        }
                    }
                    break;
                case '"':
                    break;
                case '\\':
                    break;
                default:
                    result += numMap.get(c);
            }
        }
        return result;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().romanToInt(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}