package _223_RectangleArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C <= E || B >= H || G <= A || F >= D) return (C - A) * (D - B) + (G - E) * (H - F);

        int ai = Math.max(A,E);
        int aj = Math.max(B,F);
        int bi = Math.min(C,G);
        int bj = Math.min(D,H);
        return (C - A) * (D - B) + (G - E) * (H - F) -(bj - aj) * (bi - ai);
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int A = Integer.parseInt(line);
            line = in.readLine();
            int B = Integer.parseInt(line);
            line = in.readLine();
            int C = Integer.parseInt(line);
            line = in.readLine();
            int D = Integer.parseInt(line);
            line = in.readLine();
            int E = Integer.parseInt(line);
            line = in.readLine();
            int F = Integer.parseInt(line);
            line = in.readLine();
            int G = Integer.parseInt(line);
            line = in.readLine();
            int H = Integer.parseInt(line);

            int ret = new Solution().computeArea(A, B, C, D, E, F, G, H);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
