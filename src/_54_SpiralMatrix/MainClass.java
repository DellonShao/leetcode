package _54_SpiralMatrix;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0) return result;
        int len = matrix[0].length;//列数
        int width = matrix.length;//行数
        int cnt = 0, sum = len * width;
        int level = 0, i = 0, j =0;
        while(true){
            //往右走
            while (j < len - level){
                result.add(matrix[i][j++]);
                cnt++;
            }
            if(cnt == sum) break;
            j--;
            i++;
            //往下走
            while(i < width - level){
                result.add(matrix[i++][j]);
                cnt++;
            }
            if(cnt == sum) break;
            i--;
            j--;
            //往左走
            while(j >= level){
                result.add(matrix[i][j--]);
                cnt++;
            }
            if(cnt == sum) break;
            j++;
            i--;
            //往上走
            while(i > level){
                result.add(matrix[i--][j]);
                cnt++;
            }
            if(cnt == sum) break;
            i++;
            j++;
            level++;
        }
        return result;
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] matrix = stringToInt2dArray(line);

            List<Integer> ret = new Solution().spiralOrder(matrix);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}