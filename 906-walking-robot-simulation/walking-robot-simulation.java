class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for(int[] o : obstacles){
            set.add(o[0] + "#" + o[1]);
        }
        int x = 0;
        int y = 0;
        int dir = 1;
        int maxAns = 0;
        for(int i = 0; i < commands.length; i++){
            if(commands[i] == -2){
                if(dir == 1) dir = -2;
                else if(dir == -1) dir = 2;
                else if(dir == 2) dir = 1;
                else if(dir == -2) dir = -1;
                continue;
            }
            if(commands[i] == -1){
                if(dir == 1) dir = 2;
                else if(dir == -1) dir = -2;
                else if(dir == 2) dir = -1;
                else if(dir == -2) dir = 1;
                continue;
            }
            for(int step = 0; step < commands[i]; step++){
                int nx = x;
                int ny = y;
                if(dir == 1){
                    ny++;
                }else if(dir == -1){
                    ny--;
                }else if(dir == 2){
                    nx++;
                }else if(dir == -2){
                    nx--;
                }
                if(set.contains(nx + "#" + ny)){
                    break;
                }
                x = nx;
                y = ny;
                maxAns = Math.max(maxAns, x * x + y * y);
            }
        }
        return maxAns;
    }
}