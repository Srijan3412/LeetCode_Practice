class Solution {
    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> arr=new LinkedList<>();


        int n=isConnected.length;
        int m=isConnected[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            arr.add(new LinkedList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    arr.get(i).add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(i,vis,arr);
                count++; 
            } 
        }
        return count;
    }

    public void dfs(int src, boolean[] vis, List<List<Integer>> arr){
        vis[src]=true;
        for(int itc: arr.get(src)){
            if(vis[itc]==false){
                dfs(itc,vis,arr);
            }
        }
    }
}