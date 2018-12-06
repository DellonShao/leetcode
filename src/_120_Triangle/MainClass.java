package _120_Triangle;

import com.eclipsesource.json.JsonArray;

import java.io.IOException;
import java.util.List;

class Solution {
//    int minSum = Integer.MAX_VALUE;
//    public int minimumTotal(List<List<Integer>> triangle) {
//        //深度优先算法,超出时间限制
//        dfs(triangle, 0, 0, 0);
//        return minSum;
//    }
//
//    private void dfs(List<List<Integer>> triangle, int i, int j, int sum){
//        if(i == triangle.size()) {
//            sum += triangle.get(i).get(j);
//            if(sum < minSum) minSum = sum;
//            return;
//        }
//        dfs(triangle, i + 1, j, sum + triangle.get(i).get(j));
//        dfs(triangle, i + 1, j + 1, sum + triangle.get(i).get(j));
//        return;
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //动态规划
        int row = triangle.size();
        int[][] dp = new int[row][row];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < row; ++i){
            for(int j = 0; j <= i; ++j){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);

                }else if(j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int sum = Integer.MAX_VALUE;
        for(int num : dp[row - 1]){
            if(sum > num) sum = num;
        }
        return sum;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            List<List<Integer>> triangle = stringToInt2dArray(line);
//
//            int ret = new Solution().minimumTotal(triangle);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
    }
}