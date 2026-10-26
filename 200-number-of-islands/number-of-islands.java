class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, boolean[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        q.add(new Pair(i,j));
        vis[i][j] = true;
        while(q.size() > 0){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            if(row > 0 && grid[row - 1][col] == '1' && vis[row - 1][col] == false) {
                q.add(new Pair(row - 1, col));
                vis[row - 1][col] = true;
            }
            if(row < m - 1 && grid[row + 1][col] == '1' && vis[row + 1][col] == false) {
                q.add(new Pair(row + 1, col));
                vis[row + 1][col] = true;
            }
            if(col  > 0 && grid[row][col - 1] == '1' && vis[row][col - 1] == false) {
                q.add(new Pair(row , col - 1));
                vis[row][col - 1] = true;
            }
            if(col  < n - 1 && grid[row][col + 1] == '1' && vis[row][col + 1] == false) {
                q.add(new Pair(row , col + 1));
                vis[row][col + 1] = true;
            }
        }
    }
}
