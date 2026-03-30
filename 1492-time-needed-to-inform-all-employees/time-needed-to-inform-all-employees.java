class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> Tree = new ArrayList<>();
        int [] subSum = new int[n]; 
        for(int i = 0;i < n;i++){
            Tree.add(new ArrayList<>());
        }
        for(int i = 0;i < n;i++){
            if(manager[i] == -1) continue;
            Tree.get(manager[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(headID);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int iD = q.poll();
            for(int sub : Tree.get(iD)){
                subSum[sub] = subSum[iD] + informTime[iD];
                ans = Math.max(ans,subSum[sub]);
                q.add(sub);
            }
        }
        return ans;
    }
}