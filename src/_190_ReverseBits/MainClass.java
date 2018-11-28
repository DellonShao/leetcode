package _190_ReverseBits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int cnt = 0;
        do{
            result <<= 1;
            result += n&1;
            n >>>= 1;
            cnt++;
        }while(n != 0);
        while(++cnt <= 32) {
            result <<= 1;
        }
        return result;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().reverseBits(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}