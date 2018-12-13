package _71_SimplifyPath;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> s = new Stack<>();
        for(String tmp : split){
            if(tmp.equals("")){

            }else if(tmp.equals(".")){

            }else if(tmp.equals("..")){
                if(s.empty()){

                }else{
                    s.pop();
                }
            }else{
                s.push(tmp);
            }
        }
        String result = "";
        if(s.empty()) return "/";
        while(!s.empty()){
            result = "/" + s.pop() + result;
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
            String path = stringToString(line);

            String ret = new Solution().simplifyPath(path);

            String out = (ret);

            System.out.print(out);
        }
    }
}