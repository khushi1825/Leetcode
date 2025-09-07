class Solution {

    static boolean isValid(int n_r, int n_c, int rows, int cols, boolean[][] visited, char[][] grid) {
        return (n_r >= 0 && n_r < rows && n_c >= 0 && n_c < cols &&
                !visited[n_r][n_c] && grid[n_r][n_c] == '1');
    }

    static void bfs_mat(char[][] grid, int sr, int sc, int rows, int cols, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];

            for (int i = 0; i < dr.length; i++) {
                int nbr_row = curr_row + dr[i];
                int nbr_col = curr_col + dc[i];

                if (isValid(nbr_row, nbr_col, rows, cols, visited, grid)) {
                    visited[nbr_row][nbr_col] = true;
                    q.add(new int[]{nbr_row, nbr_col});
                }
            }
        }
    }

    static int bfs_all(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs_mat(grid, i, j, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public int numIslands(char[][] grid) {
        return bfs_all(grid);
    }
}
