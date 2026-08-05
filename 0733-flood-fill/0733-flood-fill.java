class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<int[]> que = new LinkedList<>();
        int col=image[sr][sc];

        if(col == color)
            return image;
        que.add(new int[]{sr,sc});
        image[sr][sc]=color;

        int[] dx={0,0,-1,+1};
        int[] dy={-1,+1,0,0};
        while(!que.isEmpty()){
            int[] cur=que.poll();
            int m=cur[0];
            int n=cur[1];
            

            for(int l=0;l<4;l++){
                if(m+dx[l]<0 ||  n+dy[l]<0 || m+dx[l]>=image.length || n+dy[l]>=image[0].length) continue;

                // if(image[m+dx[l]][n+dy[l]]==0){
                //     continue;
                // }

                if(image[m+dx[l]][n+dy[l]]==col){
                    image[m+dx[l]][n+dy[l]]=color;
                    que.add(new int[]{m+dx[l],n+dy[l]});
                }
            }
        }
        return image;
    }
}