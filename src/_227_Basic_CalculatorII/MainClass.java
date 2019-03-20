package _227_Basic_CalculatorII;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int calculate(String s) {
        s = "10 + 65 / 5 * 10";
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        map.put('+',0);map.put('-',0);map.put('*',1);map.put('/',1);
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(c == '*' || c == '/' || c == '+'|| c == '-'){
                if(s1.isEmpty()){
                    s1.push(c);
                }else{
                    if(map.get(c) > map.get(s1.peekLast())){//优先级大
                        //获取下一个整数
                        for(int j = i + 1; j < s.length();++j){
                            char tmp = s.charAt(j);
                            if(tmp == ' ') continue;
                            else{
                                i = j;
                                break;
                            }
                        }
                        int carry = 0;
                        for(int j = i; j < s.length(); ++j){
                            char tmp = s.charAt(j);
                            if(tmp <= '9' && tmp >= '0') {
                                carry = carry * 10 + tmp - '0';
                                if (j == s.length() - 1) i = j;
                            }
                            else{
                                i = j - 1;
                                break;
                            }

                        }
                        s2.push(operate(c,s2.pop(),carry));
                    }else{//优先级一样大
                        int n1 = s2.pop();
                        int n2 = s2.pop();
                        char op = s1.pop();
                        s2.push(operate(op,n2,n1));
                        s1.push(c);
                    }
                }
            }else{
                int carry = 0;
                for(int j = i; j < s.length(); ++j){
                    char tmp = s.charAt(j);
                    if(tmp <= '9' && tmp >= '0') {
                        carry = carry * 10 + tmp - '0';
                        if (j == s.length() - 1) i = j;
                    }else{
                        i = j - 1;
                        break;
                    }
                }
                s2.push(carry);
            }
        }

        if(s2.size() == 1){
            return s2.pop();
        }else{
            int n1 = s2.pop();
            int n2 = s2.pop();
            char op = s1.pop();
            return operate(op,n2,n1);
        }
    }

    private int operate(char c, int n1, int n2){
        int result = 0;
        switch (c){
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
        }
        return result;

    }

}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().calculate(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}