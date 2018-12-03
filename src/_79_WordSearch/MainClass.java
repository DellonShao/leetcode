package _79_WordSearch;

class Solution {
//    public boolean exist(char[][] board, String word) {
//
//        if(board.length == 0) return false;
//        int m = board.length;
//        int n = board[0].length;
//        boolean[][] visited;
//        for(int i = 0; i < m; ++i){
//            for(int j = 0;j < n; ++j){
//                visited = new boolean[m][n];
//                if(board[i][j] == word.charAt(0)){
//                    boolean  result = dfs(board, word, visited, 0, i, j);
//                    if(result) return true;
//                }
//            }
//        }
//
//        return false;
//    }
//    private boolean isValid(int x, int y, char[][] board){
//        int m = board.length;
//        int n = board[0].length;
//        if(x >= 0 && x < m && y >= 0 && y < n){
//            return true;
//        }else return false;
//    }
//    private boolean dfs(char[][] board, String word, boolean[][] visited, int index, int x, int y){
//        if(index == word.length() - 1){
//            return true;
//        }
//        visited[x][y] = true;
//        //往下走
//        if(isValid(x + 1, y, board) && !visited[x + 1][y]){
//            if(board[x + 1][y] == word.charAt(index + 1)){
//                boolean b = dfs(board, word, visited, index + 1, x + 1, y);
//                if(b == true) return true;
//            }
//        }
//
//        //往右走
//        if(isValid(x, y + 1, board) && !visited[x ][y + 1]){
//            if(board[x][y + 1] == word.charAt(index + 1)){
//                boolean b = dfs(board, word, visited, index + 1, x, y + 1);
//                if(b == true) return true;
//            }
//        }
//        //往上走
//        if(isValid(x - 1, y, board) && !visited[x - 1][y]){
//            if(board[x - 1][y] == word.charAt(index + 1)){
//                boolean b = dfs(board, word, visited, index + 1, x - 1, y);
//                if(b == true) return true;
//            }
//        }
//        //往左走
//        if(isValid(x, y - 1, board) && !visited[x][y - 1]){
//            if(board[x][y - 1] == word.charAt(index + 1)){
//                boolean b = dfs(board, word, visited, index + 1, x, y - 1);
//                if(b == true) return true;
//            }
//        }
//        visited[x][y] = false;
//        return false;
//    }

    //按照以上思路简化
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(dfs(board, word, visit, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visit, int x, int y, int index){
        if(index == word.length()){
            return true;
        }
        if(x >= m || x < 0 || y >= n || y < 0) return false;

        if(visit[x][y] || board[x][y] != word.charAt(index)) return false;

        visit[x][y] = true;

        boolean result = dfs(board, word, visit, x + 1, y, index + 1)
                || dfs(board, word, visit, x, y + 1, index + 1)
                || dfs(board, word, visit, x - 1, y, index + 1)
                ||dfs(board, word, visit, x, y - 1, index + 1);

        if(!result) visit[x][y] = false;
        return result;
    }


}

public class MainClass {
    public static void main(String[] args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'}, {'A','D','E','E'}};
        String word = "ABCESEEEFS";
        Solution sol = new Solution();
        System.out.println(sol.exist(board, word));
    }
}
