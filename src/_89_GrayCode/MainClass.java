package _89_GrayCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    //回溯
    /*public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[(int)Math.pow(2.0, n)];
        result.add(0);
        visited[0] = true;
        dfs(n, result, visited, 0, 0);

        return result;
    }

    private void dfs(int n, List<Integer> result, boolean[] visited, int cnt, int pre){
        if(cnt == visited.length){
            return;
        }

        for(int i = 0; i < n; ++i){
            int tmp = pre ^ (1 << i);
            if(visited[tmp] == false){
                visited[tmp] = true;
                result.add(tmp);
                dfs(n, result, visited, cnt + 1, tmp);
            }
        }
    }*/
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int size = 1 << n;
        for(int i = 0; i < size; ++i){
            result.add(i ^ (i >> 1));
        }
        return result;
    }

}

public class MainClass {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<Integer> ret = new Solution().grayCode(n);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}