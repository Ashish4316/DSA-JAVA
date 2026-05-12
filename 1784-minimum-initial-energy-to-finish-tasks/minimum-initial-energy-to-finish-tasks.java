class Solution {
    public int minimumEffort(int[][] tasks){
        Arrays.sort(tasks,(a,b) ->  {
            return  (b[1] - b[0]) - (a[1] - a[0]);
        });
        int needTime = tasks[0][0];
        int runningTime = tasks[0][0];
        for(int [] task : tasks){
            if(runningTime - task[1] < 0){
                needTime += task[1] - runningTime;
                runningTime = task[1];
            } 
            runningTime -= task[0];
        }
        return needTime;
    }   
}