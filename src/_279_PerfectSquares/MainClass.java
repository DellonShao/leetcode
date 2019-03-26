package _279_PerfectSquares;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        //广度优先遍历,无剪枝，超出时间限制
        if(n == 0) return 0;
        int sqrt = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < sqrt; ++i){
            int result = numSquares(n - (sqrt - i) * (sqrt - i)) + 1;
            if(result < min) min = result;
        }
        return min;
    }
    public int numSquares1(int n) {
        //动态规划，找出一个状态转移方程
        int dp[] = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j * j <= i; ++j){
                //dp[n] = min(dp[n-1],dp[n-4],dp[n-9]...)+1;
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
    public int numSquares2(int n) {
        //四平方定理
        //推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)
        //分四种情况，4个数平方和，3个数平方和，以及1个数和两个数平方和
        while(n % 4 == 0){
            n /= 4;
        }
        if(n % 8 == 7){
            return 4;
        }
        int a = 0;
        while((a * a) <= n){
            int b = (int)Math.sqrt(n - a*a);
            if(a * a + b * b == n){
                if(a != 0 && b != 0){
                    return 2;
                }else{
                    return 1;
                }
            }
            ++a;
        }
        return 3;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().numSquares2(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}