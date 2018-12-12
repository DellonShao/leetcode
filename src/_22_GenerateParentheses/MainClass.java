package _22_GenerateParentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            result.add("");
            return result;
        }
        dfs(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void dfs(int n, List<String> result, StringBuilder sb, int index, int sum){
        if(index > 2 * n || sum < 0) return;
        if(index == 2 * n && sum == 0){
            result.add(sb.toString());
            return;
        }
        dfs(n, result, sb.append("("), index + 1, sum + 1);
        sb.deleteCharAt(sb.length() - 1);
        dfs(n, result, sb.append(")"), index + 1, sum - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}

public class MainClass {
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
            int n = Integer.parseInt(line);

            List<String> ret = new Solution().generateParenthesis(n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}