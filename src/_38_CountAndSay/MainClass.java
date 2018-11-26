package _38_CountAndSay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        while(n != 1){
            StringBuilder temp = new StringBuilder();
            int cnt = 0;
            char pre = sb.charAt(0);
            int len = sb.length();
            for(int i = 0; i < len; ++i){
                if(pre != sb.charAt(i)){
                    temp.append(cnt).append(pre);
                    pre = sb.charAt(i);
                    cnt = 1;
                }else{
                    cnt++;
                }
                if(i == len - 1){
                    temp.append(cnt).append(pre);
                }
            }
            sb.delete(0, len).append(temp);
            --n;
        }
        return sb.toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String ret = new Solution().countAndSay(n);

            String out = (ret);

            System.out.print(out);
        }
    }
}