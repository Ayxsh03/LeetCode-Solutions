class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] vis = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();

        // Traverse boundary rows (top and bottom)
        for (int j = 0; j < cols; j++){
            if(board[0][j] == 'O' && vis[0][j] == 0) {
                q.add(new Pair(0, j));
                vis[0][j] = 1;
            }
            if(board[rows - 1][j] == 'O' && vis[rows - 1][j] == 0){
                q.add(new Pair(rows - 1, j));
                vis[rows - 1][j] = 1;
            }
        }


        // Traverse boundary columns (left and right)
        for(int i = 0; i < rows; i++){
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                q.add(new Pair(i, 0));
                vis[i][0] = 1;
            }
            if(board[i][cols - 1] == 'O' && vis[i][cols - 1] == 0){
                q.add(new Pair(i, cols - 1));
                vis[i][cols - 1] = 1;
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 0 && x < rows && y >= 0 && y < cols && vis[x][y] == 0 && board[x][y] == 'O'){
                    q.add(new Pair(x, y));
                    vis[x][y] = 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded 'O'
                }
            }
        }
    }

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}