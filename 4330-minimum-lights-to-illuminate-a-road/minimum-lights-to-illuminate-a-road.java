class Solution {
    public int minLights(int[] lights) {
        int n  = lights.length;
        int [] range = new int[n + 1];
        for(int i = 0;i < n;i++){
            if(lights[i] > 0){
                int x = Math.max(i - lights[i],0);
                int y = Math.min(i + lights[i],n-1);
                range[x] += 1;
                if(y + 1 < n) range[y + 1] -= 1;
            }
        }
        for(int i = 0;i < n-1;i++) range[i + 1] += range[i];
        int addCount = 0;
        for(int i = 1;i < n;i++){
            if(range[i] == 0){
                if(range[i - 1] > 0) continue;
                range[i] = 1;
                range[i-1] = 1;
                range[i + 1] = 1;
                addCount++;
            }else{
                if(range[i - 1] == 0) addCount++;
            }
        }
        if(range[n - 1] == 0) addCount++;
        return addCount;
    }
}
