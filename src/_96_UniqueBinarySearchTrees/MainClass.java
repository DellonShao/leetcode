package _96_UniqueBinarySearchTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int numTrees(int n) {
        //动态规划
        int[] dp = new int[n + 1];
        if(n <= 1) return 1;
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().numTrees(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}