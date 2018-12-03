package _74_SearchA2DMatrix;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n;
        while(low < high){
            int mid = (low + high) / 2;

            if(matrix[mid / n][mid % n] == target){
                return true;
            }else if(matrix[mid / n][mid % n] < target){
                low = mid + 1;
            }else{
                high = mid;
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