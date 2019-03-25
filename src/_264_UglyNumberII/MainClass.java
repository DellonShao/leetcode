package _264_UglyNumberII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int nthUglyNumber(int n) {
        //每个数乘以2/3/5，都会产生一个新的丑数，其中一种思路就是维护x2,x3,x5的丑数位置
        //三指针思路
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int x2=0,x3=0,x5=0;
        for(int i = 1; i < n; ++i){
            uglyNumber[i] = Math.min(uglyNumber[x2] * 2, Math.min(uglyNumber[x3] * 3,uglyNumber[x5] * 5));
            if(uglyNumber[i] == uglyNumber[x2] * 2) ++x2;
            if(uglyNumber[i] == uglyNumber[x3] * 3) ++x3;
            if(uglyNumber[i] == uglyNumber[x5] * 5) ++x5;
        }
        return uglyNumber[n - 1];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().nthUglyNumber(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}