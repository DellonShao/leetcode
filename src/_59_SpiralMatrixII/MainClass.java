package _59_SpiralMatrixII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 0;
        int sum = n * n;
        int i = 0, j = 0, level = 0;
        while(true){
            //往右走
            while(j < n - level){
                result[i][j++] = ++cnt;
            }
            if(cnt == sum) break;
            ++i;
            --j;
            //往下走
            while(i < n - level){
                result[i++][j] = ++cnt;
            }
            if(cnt == sum) break;
            --i;
            --j;
            //往左走
            while(j >= level){
                result[i][j--] = ++cnt;
            }
            if(cnt == sum) break;
            --i;
            ++j;
            //往上走
            while(i > level){
                result[i--][j] = ++cnt;
            }
            if(cnt == sum) break;
            ++i;
            ++j;
            level++;
        }
        return result;
    }
}

public class MainClass {
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
            int n = Integer.parseInt(line);

            int[][] ret = new Solution().generateMatrix(n);

            String out = int2dArrayToString(ret);

            System.out.print(out);
        }
    }
}
