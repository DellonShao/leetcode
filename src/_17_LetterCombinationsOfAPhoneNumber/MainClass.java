package _17_LetterCombinationsOfAPhoneNumber;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.equals("")) return result;
        dfs(digits, result, 0, new StringBuilder());
        return result;
    }

    private void dfs(String digits, List<String> result, int index, StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        int tmp = digits.charAt(index) - '0';
        for(int i = 0; i < map[tmp].length(); ++i){
            dfs(digits, result, index + 1, sb.append(map[tmp].charAt(i)));
            sb.deleteCharAt(sb.length() - 1);
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
            String digits = stringToString(line);

            List<String> ret = new Solution().letterCombinations(digits);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}