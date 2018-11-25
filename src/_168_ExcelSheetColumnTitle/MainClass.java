package _168_ExcelSheetColumnTitle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String convertToTitle(int n) {
//        Map<Integer, Character> map = new HashMap<>();
//        for(int i = 0; i < 26; i++){
//            map.put(i + 1, Character.valueOf((char)('A' + i)));
//        }
//        StringBuilder sb  = new StringBuilder();
//        do{
//            if(n % 26 != 0){
//                sb.append(map.get(n % 26));
//            }else
//                sb.append(map.get(26));
//            n--;
//            n /= 26;
//        }while(n != 0);
//        return sb.reverse().toString();
        StringBuilder sb = new StringBuilder();
        do{
            sb.append((char)((n-1)%26 + 'A'));
            n = (n - 1) / 26;
        }while(n != 0);
        return sb.reverse().toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String ret = new Solution().convertToTitle(n);

            String out = (ret);

            System.out.print(out);
        }
    }
}