class Robot {
    int w ;
    int h ;
    int pos = 0;
    int n = 1;
    int dir = 0;
    Map<Integer,int[]> map = new HashMap<>();
    boolean moved = false;
    public Robot(int width, int height){
        w = width;
        h = height;
        int d = 0;
        for(int i = 1;i<w;i++){
            map.put(n,new int[]{i,0,d});
            n++;
        }
        d++;
        for(int j = 1;j<h;j++){
            map.put(n,new int[]{w-1,j,d});
            n++;
        }
        d++;
        for(int i = w-2;i>=0;i--){
            map.put(n,new int[]{i,h-1,d});
            n++;
        }
        d++;
        for(int j = h-2;j>=1;j--){
            map.put(n,new int[]{0,j,d});
            n++;
        }
        map.put(0,new int[]{0,0,3});
    }
    public void step(int num){
        moved = true;
        pos=(pos+num)%n;
    }
    public int[] getPos(){
        int res[] = map.get(pos);
        return new int[]{res[0],res[1]};
    }
    public String getDir(){
        if(!moved) return "East";
        int cur[] = map.get(pos);
        switch(cur[2]){
            case 0 : return "East";
            case 1 : return "North";
            case 2 : return "West";
            case 3 : return "South";
            default : return "";
        }
    }
}
