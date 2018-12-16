package _150_EvaluateReversePolishNotation;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].length() == 1 && (tokens[i].charAt(0) == '+' || tokens[i].charAt(0) == '-' || tokens[i].charAt(0) == '*' || tokens[i].charAt(0) == '/')){
                int num1 = s.pop();
                int num2 = s.pop();
                switch (tokens[i].charAt(0)){
                    case'+':
                        s.push(num2 + num1);
                        break;
                    case'-':
                        s.push(num2 - num1);
                        break;
                    case'*':
                        s.push(num2 * num1);
                        break;
                    case'/':
                        s.push(num2 / num1);
                        break;
                }
            }
            else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.peek();
    }
}

public class MainClass {
    public static String[] stringToStringArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] tokens = stringToStringArray(line);

            int ret = new Solution().evalRPN(tokens);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}