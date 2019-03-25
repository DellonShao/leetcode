package _275_H_IndexII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        int mid = (left + right) / 2;
        while(left < right){
            if(citations.length - mid > citations[mid]){
                left = mid + 1;
            }else if(citations.length - mid <= citations[mid]){
                right = mid;
            }
            mid = (left + right) / 2;
        }

        return citations.length - mid;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] citations = stringToIntegerArray(line);

            int ret = new Solution().hIndex(citations);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}