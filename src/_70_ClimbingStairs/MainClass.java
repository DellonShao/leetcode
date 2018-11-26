package _70_ClimbingStairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int climbStairs(int n) {

//        Map<Long, Long> map = new HashMap<>();
//        map.put(0L, 1L);
//        long anum = 1L;
//        for(long i = 1; i <= n; ++i){
//            anum *= i;
//            map.put(i, anum);
//        }
//
//        long cnt2 = n / 2;
//        long result = 0L;
//        for(long i = 0; i <= cnt2; ++i){
//            result += map.get(n - i) / map.get(n - i * 2) / map.get(i);
//        }
//        return (int)result;

//        //动态规划，裴波那切数列
//        if(n == 1) return 1;
//        else if(n == 2) return 2;
//        else
//            return climbStairs(n - 1) + climbStairs(n - 2);

        //剪枝
        if(n == 1) return 1;
        else if(n == 2) return 2;
        int n2 = 2;
        int fn1 = 1;
        int fn2 = 2;
        int temp = 0;
        while(n2 < n){
            temp = fn1 + fn2;
            fn1 = fn2;
            fn2 = temp;
            n2++;
        }
        return fn2;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().climbStairs(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}