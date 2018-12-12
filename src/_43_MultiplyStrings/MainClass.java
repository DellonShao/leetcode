package _43_MultiplyStrings;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        StringBuilder[] tmp = new StringBuilder[num2.length()];
        for(int i = 0; i < num2.length(); ++i){
            tmp[i] = new StringBuilder();
        }

        for(int i = num2.length() - 1; i >= 0; --i){
            int carry = 0;
            for(int j = 0; j < num2.length() - i - 1; ++j){
                tmp[i].append(0);
            }
            for(int j = num1.length() - 1; j >= 0; --j){
                int multi = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
                carry = multi / 10;
                tmp[i].append(multi % 10);
            }
            if(carry != 0) tmp[i].append(carry);
        }
        int len = tmp[0].length();
        int carry = 0;
        for(int i = 0; i < len; ++i){
            int sum = carry;
            for(int j = 0; j < tmp.length; ++j){
                if(i < tmp[j].length()){
                    sum += tmp[j].charAt(i) - '0';
                }
            }
            carry = sum / 10;
            result.append(sum % 10);
        }
        if(carry != 0) result.append(carry);
        result.reverse();
        return result.toString();
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
            String num1 = stringToString(line);
            line = in.readLine();
            String num2 = stringToString(line);

            String ret = new Solution().multiply(num1, num2);

            String out = (ret);

            System.out.print(out);
        }
    }
}