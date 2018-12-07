package _187_RepeatedDNASequences;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 10) return result;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - 9; ++i){
            String tmp = s.substring(i, i + 10);
            if(!map.containsKey(tmp)){
                map.put(tmp, 1);
            }else{
                map.replace(tmp, map.get(tmp) + 1);
                if(map.get(tmp) == 2)
                    result.add(tmp);
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

            List<String> ret = new Solution().findRepeatedDnaSequences(s);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}