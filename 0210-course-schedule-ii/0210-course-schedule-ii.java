class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Stack<Integer> st=new Stack<>();
        int[] vis=new int[numCourses];
        int[] path=new int[numCourses];
        Arrays.fill(vis,0);
        List<List<Integer>> adj=new LinkedList<>();

        for(int i=0;i<numCourses;i++) adj.add(new LinkedList<>());

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(vis,path,i,adj,st)){
                    return new int[]{};
                }
            }
        }

        int[] ans=new int[numCourses];
        int i=0;

        while(!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;

    }
    public boolean dfs(int[] vis,int[] path,int x,List<List<Integer>> adj,Stack<Integer> st){
        path[x] = 1;
        vis[x]=1;
        
        for(int i: adj.get(x)){
            if(path[i]==1){
                return false;
            }else if(vis[i]==0){
                if(!dfs(vis,path,i,adj,st)){
                    return false;
                }
            }
        }
        path[x]=0;
        st.push(x);
        return true;
    }
}