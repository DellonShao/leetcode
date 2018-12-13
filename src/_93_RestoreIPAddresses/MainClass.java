package _93_RestoreIPAddresses;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        String[] ss = new String[4];
        dfs(s, result, 0, ss, 0);
        return result;
    }

    private void dfs(String s,List<String> result, int index, String[] ss, int segment){
        if(index == s.length() && segment == 4){
            StringBuilder sb = new StringBuilder();
            sb.append(ss[0]).append(".").append(ss[1]).append(".").append(ss[2]).append(".").append(ss[3]);
            result.add(sb.toString());
            return;
        }else if(segment == 4 && index != s.length()) return;
        else if(index == s.length() && segment != 4) return;
        if(segment > 4) return;
        if(index > s.length()) return;

        if(index + 1 <= s.length()) {
            ss[segment] = s.substring(index, index + 1);
            dfs(s, result, index + 1, ss, segment + 1);
            ss[segment] = "";
        }
        if(index + 2 <= s.length()) {
            ss[segment] = s.substring(index, index + 2);
            if(ss[segment].charAt(0) != '0')
                dfs(s, result, index + 2, ss, segment + 1);
            ss[segment] = "";
        }
        if(index + 3 <= s.length() && Integer.parseInt(s.substring(index, index + 3)) <= 255){
            ss[segment] = s.substring(index, index + 3);
            if(ss[segment].charAt(0) != '0')
                dfs(s, result, index + 3, ss, segment + 1);
            ss[segment] = "";
        }
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            List<String> ret = new Solution().restoreIpAddresses(s);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}