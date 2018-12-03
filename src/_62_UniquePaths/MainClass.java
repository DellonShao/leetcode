package _62_UniquePaths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int uniquePaths(int m, int n) {
        //超时
//        if(m == 1 || n == 1){
//            return 1;
//        }
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);

//        //排列组合问题，从（m+n)步中，任意取n个歩次向下
//        m--;n--;
//        BigInteger result = BigInteger.valueOf(1);
//
//        for(int i = m + n; i > m; --i){
//            result = result.multiply(BigInteger.valueOf(i));
//        }
//        for(int i = 2; i <= n; ++i){
//            result = result.divide(BigInteger.valueOf(i));
//        }
//
//        return result.intValue();

        //排列组合
        double num = 1, d = 1;
        int smaller = m > n ? n : m;
        for(int i = 1; i < smaller; ++i){
            num *= m + n - 1 - i;
            d *= i;
        }
        return (int) (num / d);
//        //动态规划
//        int[][] dp = new int[m][n];
//        for(int i = 0; i < m; ++i){
//            for(int j = 0; j < n; ++j){
//                if(i == 0 || j == 0) dp[i][j] = 1;
//                else
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new Solution().uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
