class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int minLandFinishTime = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            minLandFinishTime = Math.min(minLandFinishTime, landStartTime[i] + landDuration[i]);
        }

        int minWaterFinishTime = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++){
            minWaterFinishTime = Math.min(minWaterFinishTime, waterStartTime[i] + waterDuration[i]);
        }

        int answerFromLand = Integer.MAX_VALUE;
        for(int i = 0; i < waterStartTime.length; i++){
            int start = Math.max(minLandFinishTime, waterStartTime[i]);
            answerFromLand = Math.min(answerFromLand, waterDuration[i] + start);
        }

        int answerFromWater = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            int start = Math.max(minWaterFinishTime, landStartTime[i]);
            answerFromWater = Math.min(answerFromWater, landDuration[i] + start);
        }
        return Math.min(answerFromLand, answerFromWater);
    }
}