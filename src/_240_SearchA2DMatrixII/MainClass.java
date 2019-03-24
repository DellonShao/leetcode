package _240_SearchA2DMatrixII;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //角度思考问题，左下角的点有一个性质就是，往上走比他小，往右走比他的大
        //这就是一个二叉排序树
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0, y = row - 1;
        while(x < col && y >= 0){
            if(matrix[y][x] == target) return true;
            else if(matrix[y][x] > target){
                //往上走
                y--;
            }else if(matrix[y][x] < target){
                //往右走
                x++;
            }
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            boolean ret = new Solution().searchMatrix(matrix, target);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}