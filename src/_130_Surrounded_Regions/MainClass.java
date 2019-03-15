package _130_Surrounded_Regions;


class Solution {
    public void solve() {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        int rowLen = board.length;
        int colLen = board[0].length;
        int top = 0, bottom = rowLen - 1;
        int left = 0, right = colLen - 1;
        for(; top < rowLen; ++top){
            boolean flag = false;
            for(int i = 0; i < colLen; ++i){
                if(board[top][i] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }

        for(; bottom >= top; --bottom){
            boolean flag = false;
            for(int i = 0; i < colLen; ++i){
                if(board[bottom][i] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }

        for(; left < colLen; ++left){
            boolean flag = false;
            for(int i = top; i <= bottom; ++i){
                if(board[i][left] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }

        for(; right >= left; --right){
            boolean flag = false;
            for(int i = top; i <= bottom; ++i){
                if(board[i][right] == 'X'){
                    flag = true;
                    break;
                }
            }
            if(flag == true) break;
        }
        top++;bottom--;left++;right--;
        for(; top <= bottom; ++top){
            for(int i = left; i <= right; ++i){
                if(board[top][i] == 'O'){
                    board[top][i] = 'X';
                }
            }
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }

}
