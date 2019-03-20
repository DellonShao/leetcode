package _221_MaximalSquare;


class Solution {
    public int maximalSquare(char[][] matrix) {
        //暴力解法
        int length = matrix.length;
        if(length <= 0) return 0;
        int width = matrix[0].length;
        //int len = length * width;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length; ++i){ //行遍历
            for(int j = 0; j < width; ++j){ //列遍历
                if(matrix[i][j] == '1'){
                    for(int m = i, n = j; m < length && n < width; ++m, ++n){
                        //判断是否存在正方形
                        int m1 = j, n1 = i;
                        boolean flag = false;
                        while(m1 < width && n1 < length && m1 <= n && n1 <= m){
                            if(matrix[m][m1] != '1' || matrix[n1][n] != '1'){
                                //m1--;n1--;
                                //不存在正方形
                                flag = true;
                                break;
                            }
                            m1++;n1++;
                        }
                        if(flag == true){
                            break;
                        }else if(flag == false && max < m - i + 1){
                            max = m - i + 1;
                        }
                    }
                }
            }
        }
        return max * max;
    }

    public int maximalSquare1(char[][] matrix) {
        //动态规划
        //dp[i][j]表示以第i行第j列为正方形右下角所能构成的最大正方形边长, 则递推式为:
        //dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
    }
}


public class MainClass {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(s.maximalSquare(matrix));
    }

}
