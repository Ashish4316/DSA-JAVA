class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinish = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            for(int j = 0; j < waterStartTime.length;j++){
                int landStart = landStartTime[i];
                int landFinish = landStart + landDuration[i];
                int waterStartAfterLand = Math.max(landFinish, waterStartTime[j]);
                int totalFinish1 = waterStartAfterLand + waterDuration[j];
                minFinish = Math.min(minFinish, totalFinish1);
                int waterStart = waterStartTime[j];
                int waterFinish = waterStart + waterDuration[j];
                int landStartAfterWater = Math.max(waterFinish, landStartTime[i]);
                int totalFinish2 = landStartAfterWater + landDuration[i];
                minFinish = Math.min(minFinish, totalFinish2);
            }
        }
        return minFinish;
    }
}