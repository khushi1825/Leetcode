class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (clear(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean clear(char[][] board, String word, int idx, int r, int c) {
        if (idx==word.length()){
            return true;
        }

        if (r<0 || r>=board.length || c<0 || c>=board[0].length 
            || board[r][c]!=word.charAt(idx)) {
            return false;
        }

        char temp=board[r][c];
        board[r][c]='0';

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d:dir){
            if (clear(board,word,idx+1,r+d[0],c+d[1])){
                board[r][c]=temp; 
                return true;
            }
        }
        board[r][c]=temp;
        return false;
    }
}
