package _20_ValidParentheses;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; ++i){
            char c = s.charAt(i);
            if(c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}'){
                if(stack.empty()){
                    if(c == '(' || c == '[' || c == '{'){
                        stack.push(c);
                    }else{
                        return false;
                    }
                }else{
                    char temp = stack.peek();

                    switch(temp){
                        case ')' | ']' | '}':
                            return false;
                        case '(':
                            if(c == ')'){
                                stack.pop();
                            }else{
                                stack.push(c);
                            }
                            break;
                        case '[':
                            if(c == ']'){
                                stack.pop();
                            }else{
                                stack.push(c);
                            }
                            break;
                        case '{':
                            if(c == '}'){
                                stack.pop();
                            }else{
                                stack.push(c);
                            }
                            break;
                    }
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            boolean ret = new Solution().isValid(s);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}