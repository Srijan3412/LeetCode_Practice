class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1 && grid[i][j]=='1'){
                    bfs(vis,i,j,grid);
                    count++;
                }
            }
        }return count;
    }
    public void bfs(int[][] vis,int x,int y,char[][] grid){
        vis[x][y]=1;
        int[] dx={+1,-1,0,0};
        int[] dy={0,0,+1,-1};
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{x,y});
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] curr=que.poll();
                int a=curr[0];
                int b=curr[1];
                for(int m=0;m<dx.length;m++){
                    if(a+dx[m]>=0 && a+dx[m]<grid.length && b+dy[m]>=0 && b+dy[m]<grid[0].length &&
                    vis[a+dx[m]][b+dy[m]]!=1 && grid[a+dx[m]][b+dy[m]]=='1'){
                        vis[a+dx[m]][b+dy[m]]=1;
                        que.add(new int[]{a+dx[m],b+dy[m]});
                    }
                }
            }
        }
    }
}