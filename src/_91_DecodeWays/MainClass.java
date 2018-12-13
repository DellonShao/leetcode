package _91_DecodeWays;

import java.io.IOException;

class Solution {
    public int numDecodings(String s) {
        //动态规划
        int[] d = new int[s.length() + 1];
        if(s.length() == 1 && s.charAt(0) != '0') return 1;
        else if(s.length() == 1 && s.charAt(0) == '0') return 0;

        if(s.charAt(s.length() - 1) == '0')d[1] = 0;
        else d[1] = 1;
        if(s.substring(s.length() - 2, s.length()).equals("00")) d[0] = 0;
        else d[0] = 1;

        for(int i = 2; i <= s.length(); ++i){
            String tmp1 = s.substring(s.length() - i, s.length() - i + 2);
            String tmp2 = s.substring(s.length() - i, s.length() - i + 1);
            if(Integer.parseInt(tmp1) <= 26 && Integer.parseInt(tmp1) >= 10 && Integer.parseInt(tmp2) >= 1){
                d[i] = d[i - 1] + d[i - 2];
            }else if(Integer.parseInt(tmp2) >= 1){
                d[i] = d[i - 1];
            }
        }
        return d[s.length()];
    }
}

public class MainClass {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        System.out.println(s.numDecodings("010"));
    }
}