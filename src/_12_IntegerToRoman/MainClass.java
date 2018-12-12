package _12_IntegerToRoman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public String intToRoman(int num) {
        /*Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");*/
        //不想动脑，可以打表简化，就这样吧
        StringBuilder sb = new StringBuilder();
        while(num - 1000 >= 0){
            sb.append("M");
            num -= 1000;
        }
        while(num - 900 >= 0){
            sb.append("CM");
            num -= 900;
        }
        while(num - 500 >= 0){
            sb.append("D");
            num -= 500;
        }
        while(num - 400 >= 0){
            sb.append("CD");
            num -= 400;
        }
        while(num - 100 >= 0){
            sb.append("C");
            num -= 100;
        }
        while(num - 90 >= 0){
            sb.append("XC");
            num -= 90;
        }
        while(num - 50 >= 0){
            sb.append("L");
            num -= 50;
        }
        while(num - 40 >= 0){
            sb.append("XL");
            num -= 40;
        }
        while(num - 10 >= 0){
            sb.append("X");
            num -= 10;
        }
        while(num - 9 >= 0){
            sb.append("IX");
            num -= 9;
        }
        while(num - 5 >= 0){
            sb.append("V");
            num -= 5;
        }
        while(num - 4 >= 0){
            sb.append("IV");
            num -= 4;
        }
        while(num - 1 >= 0){
            sb.append("I");
            num -= 1;
        }
        return sb.toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new Solution().intToRoman(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}