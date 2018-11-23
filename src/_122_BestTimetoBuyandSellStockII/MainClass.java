package _122_BestTimetoBuyandSellStockII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int maxProfit(int[] prices) {
//        if(prices.length == 0) return 0;
//        int maxProfit = 0;
//        int min = prices[0];
//        boolean flag = false;
//        for(int i = 1; i < prices.length; ++i){
//            if(prices[i - 1] > prices[i]){
//                maxProfit += prices[i - 1] - min;
//                min = prices[i];
//                if(i == prices.length - 1) flag = true;
//            }
//        }
//        if(flag == false){
//            maxProfit += prices[prices.length - 1] - min;
//        }
//        return maxProfit;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
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
            int[] prices = stringToIntegerArray(line);

            int ret = new Solution().maxProfit(prices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}