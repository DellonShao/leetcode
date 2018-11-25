package _172_FactorialTrailingZeroes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        do{
            n /= 5;
            cnt += n;
        }while(n != 0);
        return cnt;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().trailingZeroes(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}