package _166_FractionToRecurringDecimal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> maps = new HashMap<>();//store divid number
        List<Long> number = new ArrayList<>();
        int index = 0;
        int beginIndex = -1;

        StringBuilder builder = new StringBuilder();
        if(denominator==0)
            return "";
        long num = numerator;
        long denum = denominator;
        if((num<0 && denum>0) || (num>0 && denum<0))
            builder.append('-');

        num = Math.abs(num);
        denum = Math.abs(denum);

        long val = num/denum;
        builder.append(String.valueOf(val));
        num = (num%denum)*10;

        while(num!=0){
            if(maps.containsKey(num)){//开始重复
                beginIndex = maps.get(num);
                break;
            }else{

                maps.put(num, index++);
                val = num/denum;
                num = (num%denum)*10;
                number.add(val);
            }
        }
        for(int i = 0;i<index;i++){
            if(i==0)
                builder.append('.');
            if(i==beginIndex){
                builder.append('(');
            }
            builder.append(number.get(i));
        }
        if(beginIndex!=-1)
            builder.append(')');

        return builder.toString();
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numerator = Integer.parseInt(line);
            line = in.readLine();
            int denominator = Integer.parseInt(line);

            String ret = new Solution().fractionToDecimal(numerator, denominator);

            String out = (ret);

            System.out.print(out);
        }
    }
}