package _28_Implement_strStr;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int p1 = 0;
        int p2 = 0;
        for(;p1 < haystack.length(); ++p1){
            if(haystack.charAt(p1) == needle.charAt(p2)){
                ++p2;
                if(p2 == needle.length()) return p1 - needle.length() + 1;
            }else{
                p1 = p1 - p2;
                p2 = 0;
            }
        }
        return -1;
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
            String haystack = stringToString(line);
            line = in.readLine();
            String needle = stringToString(line);

            int ret = new Solution().strStr(haystack, needle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}