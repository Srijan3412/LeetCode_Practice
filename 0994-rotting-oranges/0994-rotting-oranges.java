class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        int fresh=0;
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    total++;
                    que.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int count=0;
        int[] dx={0,0,+1,-1};
        int[] dy={+1,-1,0,0};

        while(!que.isEmpty()){
            int size=que.size();
            for(int l=0;l<size;l++){

                int[] curr=que.poll();
                int m=curr[0];
                int n=curr[1];

                for(int i=0;i<4;i++){
                    if(m+dx[i]<0 || n+dy[i]<0 || m+dx[i]>=grid.length || n+dy[i]>=grid[0].length || grid[m+dx[i]][n+dy[i]]==0){
                        continue;
                    }
                    if(grid[m+dx[i]][n+dy[i]]==1){
                        fresh--;
                        grid[m+dx[i]][n+dy[i]]=2;
                        que.add(new int[]{m+dx[i],n+dy[i]});
                    }
                }
            }
            if(!que.isEmpty()){
                count++;
            }
        }
        if(fresh>0) return -1;
        return count;
    }
}