class Solution {
    public boolean isBipartite(int[][] graph) {

        int m=graph.length;
        int n=graph[0].length;
        int[] col=new int[m];
        Arrays.fill(col,-1);
        boolean ans=false;

        for(int i=0;i<m;i++){
            if(col[i]==-1){
                if(!dfs(col,i,graph,1)){
                    return false;
                }
            }
        }
        return true;  
    }
    public boolean dfs(int[] col,int x,int[][] graph,int color){
        col[x]=color;
        for(int itr: graph[x]){
            if(col[itr]==color){
                return false;
            }
            if(col[itr]==-1){
                if(!dfs(col,itr,graph,1-color)){
                    return false;
                }
            }
        }
        return true;
    }
}