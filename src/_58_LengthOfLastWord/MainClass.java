package _58_LengthOfLastWord;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] result = s.split(" ");
        if(result.length == 0) return 0;
        return result[result.length - 1].length();
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

            int ret = new Solution().lengthOfLastWord(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}