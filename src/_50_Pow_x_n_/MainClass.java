package _50_Pow_x_n_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Solution {
    public double myPow(double x, int n) {
        //快速幂
        double result = 1.0f;
        boolean flag = false;
        if(n < 0){
            flag = true;
            if(n == Integer.MIN_VALUE){
                result *= x;
                n = Integer.MAX_VALUE;
            }
            n = Math.abs(n);
        }

        while(n > 0){
            if((n & 1) == 1){
                result *= x;
            }
            x= x * x;
            n >>= 1;
        }
        if(flag) return 1 / result;
        else return result;
    }
}

public class MainClass {
    public static String doubleToString(String input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            double x = Double.parseDouble(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            double ret = new Solution().myPow(x, n);

            String out = doubleToString(Double.toString(ret));

            System.out.print(out);
        }
    }
}