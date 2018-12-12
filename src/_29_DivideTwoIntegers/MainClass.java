package _29_DivideTwoIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = true;
        if (dividend > 0 && divisor < 0 || (dividend < 0 && divisor > 0)) {
            isPositive = false;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int shift = 0;
        int result = 0;

        while (a >= b) {
            while (a >= b << shift) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
            shift = 0;
        }

        return isPositive ? result : -result;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int dividend = Integer.parseInt(line);
            line = in.readLine();
            int divisor = Integer.parseInt(line);

            int ret = new Solution().divide(dividend, divisor);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}