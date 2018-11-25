package _69_Sqrt_x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int mySqrt(int x) {
//        //二分查找
//        int low = 0, high = x / 2 + 1;
//        while(low <= high){
//            int mid = (low + high) / 2;
//            long temp = (long)mid * (long)mid;
//            if(temp == x) return mid;
//            else if(temp < x){
//                low = mid + 1;
//            }else
//                high = mid - 1;
//        }
//
//        return high;

        //牛顿拟合法 x1 = x0 - (x0 - x / x0) / 2 = (x0 + x / x0) / 2
        if(x == 0) return 0;
        long x0 = x;
        //x0 - x / x0 > 0 ---> x1 < x0
        //停止条件 x0 <= x1,即在零点左边
        while(x0 > x / x0){
            x0 = (x0 + x / x0) / 2;
        }
        return (int)x0;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().mySqrt(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}