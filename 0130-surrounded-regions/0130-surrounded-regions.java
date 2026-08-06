class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                dfs(vis,board,i,0);
            }
            if(board[i][n-1] == 'O'){
                dfs(vis,board,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O'){
                dfs(vis,board,0,i);
            }
            if(board[m-1][i] == 'O'){
                dfs(vis,board,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void dfs(int[][] vis,char[][] board,int x,int y){
        vis[x][y]=1;
        int[] dx={-1,+1,0,0};
        int[] dy={0,0,-1,+1};
        for(int i=0;i<4;i++){
            if(x+dx[i]>=0 && x+dx[i]<board.length && y+dy[i]>=0 && y+dy[i]<board[0].length && board[x+dx[i]][y+dy[i]]=='O' && vis[x+dx[i]][y+dy[i]]!=1){
                dfs(vis,board,x+dx[i],y+dy[i]);
            }
        }
    }
}