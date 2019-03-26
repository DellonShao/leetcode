package _289_GameOfLife;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0;i < board.length; ++i){//行
            for(int j = 0; j < board[0].length; ++j){//列
                int cnt = 0;//计算活细胞数
                //计算上面3个
                if(i >= 1){
                    if(j >= 1 && board[i - 1][j - 1] % 2 == 1) cnt++;
                    if(board[i-1][j] % 2 == 1) cnt++;
                    if(j + 1 < board[0].length && board[i - 1][j + 1] % 2 == 1) cnt++;
                }
                //计算中间两个
                if(j >= 1 && board[i][j - 1] % 2 == 1) cnt++;
                if(j + 1 < board[0].length && board[i][j + 1] % 2 == 1) cnt++;
                //计算下面3个
                if(i + 1 < board.length){
                    if(j >= 1 && board[i + 1][j - 1] % 2 == 1) cnt++;
                    if(board[i + 1][j] % 2 == 1) cnt++;
                    if(j + 1 < board[0].length && board[i + 1][j + 1] % 2 == 1) cnt++;
                }
                if(board[i][j] == 1 && (cnt < 2 || cnt > 3)){
                    board[i][j] = 3;//变成死细胞
                }else if(board[i][j] == 0 && cnt == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == 2) board[i][j] = 1;
                else if(board[i][j] == 3) board[i][j] = 0;
            }
        }
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] board = stringToInt2dArray(line);

            new Solution().gameOfLife(board);
            String out = int2dArrayToString(board);

            System.out.print(out);
        }
    }
}