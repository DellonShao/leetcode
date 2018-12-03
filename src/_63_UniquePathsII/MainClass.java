package _63_UniquePathsII;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划
        int m = obstacleGrid.length;//行数
        int n = obstacleGrid[0].length;//列数
        int[][] dp = new int[m][n];
        //处理边缘
        for(int i = 0; i < m; ++i){
            if(obstacleGrid[m - i - 1][n - 1] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; ++i){
            if(obstacleGrid[m - 1][n - i - 1] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(obstacleGrid[m - i - 1][n - j - 1] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] obstacleGrid = stringToInt2dArray(line);

            int ret = new Solution().uniquePathsWithObstacles(obstacleGrid);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}