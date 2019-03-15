package _201_BitwiseANDofNumbersRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //从高位向低位与，利用 n&(n-1)的特性： n & (n - 1) 可以将 n 最右边的 1 变成 0
        while(n > m){
            n &= (n-1);
        }

        return n;
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

            int ret = new Solution().rangeBitwiseAnd(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}