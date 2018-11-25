package _125_ValidPalindrome;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;

        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2){
            if(!Character.isDigit(s.charAt(p1)) && !Character.isAlphabetic(s.charAt(p1))){
                p1++;
                continue;
            }
            if(!Character.isDigit(s.charAt(p2)) && !Character.isAlphabetic(s.charAt(p2))){
                p2--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))){
                return false;
            }
            p1++;p2--;
        }
        return true;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new Solution().isPalindrome(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}