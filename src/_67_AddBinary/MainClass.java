package _67_AddBinary;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length() || i < b.length(); ++i){
            int na = 0, nb = 0;
            if(i >= a.length() || !Character.isDigit(a.charAt(i))){
                na = 0;
            }else
                na = Character.getNumericValue(a.charAt(i));
            if(i >= b.length() || !Character.isDigit(b.charAt(i))){
                nb = 0;
            }else
                nb = Character.getNumericValue(b.charAt(i));
            if(i < a.length() && i < b.length() && !Character.isDigit(a.charAt(i)) && !Character.isDigit(b.charAt(i))){
                continue;
            }
            int temp = na + nb + carry;
            carry = temp / 2;
            sb.append(temp % 2);

        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
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
            String a = stringToString(line);
            line = in.readLine();
            String b = stringToString(line);

            String ret = new Solution().addBinary(a, b);

            String out = (ret);

            System.out.print(out);
        }
    }
}