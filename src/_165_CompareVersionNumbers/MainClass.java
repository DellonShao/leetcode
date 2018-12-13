package _165_CompareVersionNumbers;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1split = version1.split("\\.");
        String[] v2split = version2.split("\\.");

        for(int i = 0; i < v1split.length || i < v2split.length; ++i){
            int tmp1, tmp2;
            if(i < v1split.length){
                tmp1 = Integer.parseInt(v1split[i]);
            }else tmp1 = 0;
            if(i < v2split.length){
                tmp2 = Integer.parseInt(v2split[i]);
            }else tmp2 = 0;

            if(tmp1 < tmp2){
                return -1;
            }else if(tmp1 > tmp2){
                return 1;
            }
        }
        return 0;
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
            String version1 = stringToString(line);
            line = in.readLine();
            String version2 = stringToString(line);

            int ret = new Solution().compareVersion(version1, version2);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}