package _191_NumberOf1Bits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i = 0; i < 32; ++i){
            cnt += n&1;
            n >>>= 1;
        }
        return cnt;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().hammingWeight(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}