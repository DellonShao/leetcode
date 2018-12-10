package _36_ValidSudoku;


class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] visited = new boolean[9][10];
        boolean[][] rowVis = new boolean[9][10];
        boolean[][] colVis = new boolean[9][10];

        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '.') continue;
                int pos = 0;
                if(i <= 2 && j <= 2) pos = 0;
                else if(i <= 2 && j <= 5) pos = 1;
                else if(i <= 2 && j <= 8) pos = 2;
                else if(i <= 5 && j <= 2) pos = 3;
                else if(i <= 5 && j <= 5) pos = 4;
                else if(i <= 5 && j <= 8) pos = 5;
                else if(i <= 8 && j <= 2) pos = 6;
                else if(i <= 8 && j <= 5) pos = 7;
                else if(i <= 8 && j <= 8) pos = 8;

                if(rowVis[i][board[i][j] - '0'] == false) rowVis[i][board[i][j] - '0'] = true;
                else return false;
                if(colVis[j][board[i][j] - '0'] == false) colVis[j][board[i][j] - '0'] = true;
                else return false;
                if(visited[pos][board[i][j] - '0'] == false) visited[pos][board[i][j] - '0'] = true;
                else return false;
            }
        }
        return true;
    }
}

public class MainClass {
}
