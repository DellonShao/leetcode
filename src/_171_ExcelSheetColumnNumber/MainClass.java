package _171_ExcelSheetColumnNumber;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int titleToNumber(String s) {
        int cnt = 0;
        int len = s.length() - 1;
        for(int i = 1; i < len; ++i){
            cnt = cnt * 26 + s.charAt(i) - 'A' + 1;
        }

        return cnt;
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

            int ret = new Solution().titleToNumber(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}