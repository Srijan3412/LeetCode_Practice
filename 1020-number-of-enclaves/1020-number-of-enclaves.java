class Solution {
    public int numEnclaves(int[][] grid) {
        
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            if(grid[i][0] == 1 && vis[i][0]!=1){
                bfs(vis,grid,i,0);
            }
            if(grid[i][n-1] == 1 && vis[i][n-1]!=1){
                bfs(vis,grid,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i] == 1 && vis[0][i]!=1){
                bfs(vis,grid,0,i);
            }
            if(grid[m-1][i] == 1 && vis[m-1][i]!=1){
                bfs(vis,grid,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(int[][] vis,int[][] grid,int x,int y){
        vis[x][y]=1;
        Queue<int[]> que=new LinkedList<>();

        int[] dx={0,0,-1,+1};
        int[] dy={-1,1,0,0};

        que.add(new int[]{x,y});
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] curr=que.poll();
                for(int j=0;j<4;j++){
                    if(curr[0]+dx[j]>=0 && curr[0]+dx[j]<grid.length && curr[1]+dy[j]>=0 && curr[1]+dy[j]<grid[0].length && vis[curr[0]+dx[j]][curr[1]+dy[j]]!=1 && grid[curr[0]+dx[j]][curr[1]+dy[j]]==1){
                        vis[curr[0]+dx[j]][curr[1]+dy[j]]=1;
                        que.add(new int[]{curr[0]+dx[j],curr[1]+dy[j]});
                    }
                }

            }
        }
    }
}