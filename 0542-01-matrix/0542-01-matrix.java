class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    que.add(new int[]{i,j});
                    vis[i][j]=1;
                }
            }
        }
        int[] dx={-1,+1,0,0};
        int[] dy={0,0,+1,-1};
        int step=1;
        int[][] dist=new int[m][n];

        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] curr=que.poll();
                int x=curr[0];
                int y=curr[1];
                for(int j=0;j<4;j++){
                    if(x+dx[j]<0 || x+dx[j] >= m || y+dy[j]<0 || y+dy[j] >= n){
                        continue;
                    }
                    if(vis[x+dx[j]][y+dy[j]]!=1){
                        dist[x+dx[j]][y+dy[j]]=step;
                        vis[x+dx[j]][y+dy[j]]=1;
                        que.add(new int[]{x+dx[j],y+dy[j]});
                    }
                }
            }
            step++;
        }
        return dist;
    }
}