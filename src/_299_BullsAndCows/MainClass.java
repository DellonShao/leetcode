package _299_BullsAndCows;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String getHint(String secret, String guess) {
        //巨麻烦的方法，不好
        List<Set<Integer>> lSecret = new ArrayList<>();
        List<Set<Integer>> lGuess = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            lSecret.add(new HashSet<>());
            lGuess.add(new HashSet<>());
        }
        int len = secret.length();
        for(int i = 0; i < len; ++i){
            lSecret.get(secret.charAt(i)- '0').add(i);
            lGuess.get(guess.charAt(i) - '0').add(i);
        }
        int bull = 0, cow = 0;//位置猜对了的，数猜对了的
        for(int i = 0; i < 10; ++i){
            int cnt = lSecret.get(i).size();
            lSecret.get(i).retainAll(lGuess.get(i));
            bull += lSecret.get(i).size();
            cow = cow + (cnt <= lGuess.get(i).size()?cnt:lGuess.get(i).size()) - lSecret.get(i).size();
        }
        return bull + "A" + cow + "B";
    }
    public String getHint1(String secret, String guess) {
        int[] sFreq=new int[10];
        int[] gFreq=new int[10];
        int bulls=0,cows=0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s==g){
                bulls++;
            }else {
                sFreq[s-'0']++;
                gFreq[g-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows+=Math.min(sFreq[i],gFreq[i]);
        }
        return bulls+"A"+cows+"B";
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
            String secret = stringToString(line);
            line = in.readLine();
            String guess = stringToString(line);
            secret = "1123";
            guess = "0111";
            String ret = new Solution().getHint(secret, guess);

            String out = (ret);

            System.out.print(out);
        }
    }
}