package _73_SetMatrixZeroes;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void setZeroes(int[][] matrix) {
//        List<Integer> row = new ArrayList<>();
//        List<Integer> column = new ArrayList<>();
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for(int i = 0; i < m; ++i){
//            for(int j = 0; j < n; ++j){
//                if(matrix[i][j] == 0){
//                    row.add(i);
//                    column.add(j);
//                }
//            }
//        }
//
//        for(int i = 0; i < row.size(); ++i){
//            for(int j = 0; j < n; ++j){
//                matrix[row.get(i)][j] = 0;
//            }
//        }
//        for(int i = 0; i < column.size(); ++i){
//            for(int j = 0; j < m; ++j){
//                matrix[j][column.get(i)] = 0;
//            }
//        }

        //技巧：利用第一行和第一列设置标记
        boolean fc = false, fr = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; ++i){
            if(matrix[i][0] == 0) fc = true;
        }
        for(int j = 0; j < n; ++j){
            if(matrix[0][j] == 0) fr = true;
        }

        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; ++i){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; ++j){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; ++i){
                    matrix[i][j] = 0;
                }
            }
        }
        if(fc){
            for(int i = 0; i < m; ++i){
                matrix[i][0] = 0;
            }
        }
        if(fr){
            for(int j = 0; j < n; ++j){
                matrix[0][j] = 0;
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

            sb.append("[");
            for(int it : item){
                sb.append(Integer.toString(it));
                sb.append(",");
            }
            sb.setCharAt(sb.length() - 1, ']');
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            new Solution().setZeroes(matrix);
            String out = int2dArrayToString(matrix);

            System.out.print(out);
        }
    }
}