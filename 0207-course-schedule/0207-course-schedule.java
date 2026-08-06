class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
            int course=i[0];
            int needed=i[1];

            graph.get(needed).add(course);
            inDegree[course]++;
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                que.add(i); 
            }
        }
        List<Integer> res=new ArrayList<>();
        
        while(!que.isEmpty()){
            int completedCourse=que.poll();
            res.add(completedCourse);
            for(int eligibleCourses:graph.get(completedCourse)){
                inDegree[eligibleCourses]--;
                if(inDegree[eligibleCourses]==0){
                    que.add(eligibleCourses);
                }
            }
        }
        if(numCourses!=res.size()) return false;
        int[] temp=new int[numCourses];
        for(int i=0;i<res.size();i++){
            temp[i]=res.get(i);
        }
        return true;
    }
}