class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adj=new LinkedList<>();
        int m=graph.length;
        int n=graph[0].length;
        for(int i=0;i<m;i++) adj.add(new LinkedList<>());
       
        int[] indegree=new int[m];
        Arrays.fill(indegree,0);
        for(int i=0;i<m;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                indegree[i]++;
            }
        }   
        List<Integer> ans=new LinkedList<>();   
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int x=que.poll();
            ans.add(x);

            for(int j:adj.get(x)){
                indegree[j]--;
                if(indegree[j]==0){
                    que.add(j);
                }
                
            }   
        }
        Collections.sort(ans);
        return ans;
    }
}