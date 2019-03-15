package _200_NumberOfIslands;

import java.util.HashSet;
import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        //char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        int result = s.numIslands1(grid);
        System.out.println(result);
    }

}


class Solution {
    public int numIslands(char[][] grid) {
        //采用并查集
        int len1 = grid.length;//行
        if(len1 <= 0) return 0;
        int len2 = grid[0].length;//列
        int cnt = len1 * len2;
        int[] father = new int[cnt];
        for(int i = 0; i < cnt; ++i){
            father[i] = i;
        }
        for(int i = 0; i < len1; ++i){
            for(int j = 0; j < len2; ++j){
                if(grid[i][j] == '0'){
                    father[i * len2 + j] = -1;
                }else{
                    int fa = -1,fb = -1;
                    if(i > 0 && grid[i - 1][j] == '1'){
                        fa = findFather(father, (i - 1) * len2 + j);
                        father[i * len2 + j] = fa;
                    }
                    if(j > 0 && grid[i][j - 1] == '1'){
                        fb = findFather(father, i * len2 + j - 1);
                        father[i * len2 + j] = fb;
                    }
                    if(fa != -1 && fb != -1 && fa != fb){
                        father[fa] = fb;
                    }
                }
            }
        }
        int[] flag = new int[cnt];
        int n = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if(grid[i][j] != '0'){
                    set.add(findFather(father,i * len2 + j));
                }
            }
        }
        return set.size();
    }


    private int findFather(int[] father,int x){
        int a = x;
        while(x != father[x]){
            x = father[x];
        }
        //路径压缩
        while(a != father[a]){
            int z = a;
            a = father[a];
            father[z] = x;
        }
        return x;
    }
//    private void union(int[] father, int a, int b){
//        int faA = findFather(father, a);
//        int faB = findFather(father, b);
//        if(faA != faB){
//            father[faA] = faB;
//        }
//    }
    public int numIslands1(char[][] grid){
        int cnt = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') return ;

        grid[i][j] = '0';

        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j + 1);
    }
}