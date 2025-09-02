import java.util.*;

class Solution {
    
    static boolean isValid(int r,int c,int rows,int cols,int[][] grid){
        return (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1);
    }
    
    
    static int bfs_mat(int[][] grid, Queue<int[]> q, int fresh, int rows, int cols){
        int minutes = -1;        
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        
        while(!q.isEmpty()){
            int size = q.size();
            minutes++;
            
            for(int s=0; s<size; s++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int i=0;i<dr.length;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    
                    if(isValid(nr,nc,rows,cols,grid)){
                        grid[nr][nc] = 2;  
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        
        if(fresh == 0){
            return minutes;
        } else {
            return -1;
        }
    }
    
   
    static int bfs_all(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) 
            return 0;
        return bfs_mat(grid,q,fresh,rows,cols);
    }
    
    public int orangesRotting(int[][] grid) {
        return bfs_all(grid);
    }
}
