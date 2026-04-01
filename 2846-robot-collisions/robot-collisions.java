class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = healths.length;
        List<int[]> list = new ArrayList<>(); //[i,h,p]
        for(int i = 0;i < n;i++){
            int p = (directions.charAt(i) == 'R')? 0 : 1; 
            int [] ans = {positions[i],healths[i],p};
            list.add(ans);
        }
        Collections.sort(list,(a,b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>(); //[h,p,i]
        for(int k = 0;k < n;k++){
            int i = list.get(k)[0];
            int h = list.get(k)[1];
            int l = list.get(k)[2];
            if(!st.isEmpty() && l == 1){
                while(!st.isEmpty() && st.peek()[1] == 0){
                    if(h > st.peek()[0]){
                        st.pop();
                        h = h - 1;
                    }else if(h < st.peek()[0]){
                        int [] val = st.pop();
                        h = 0;
                        st.add(new int [] {val[0] - 1,0,val[2]});
                        break;
                    }else{
                        h = 0;
                        st.pop();
                        break;
                    }
                }
                if(h != 0){
                    st.add(new int [] {h,1,i});
                }
            }else{
                st.add(new int [] {h,l,i});
            }
        }
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        if(st.isEmpty()){
            return ans;
        }
        while(!st.isEmpty()){
            int [] val = st.pop();
            map.put(val[2],val[0]);
        }
        for(int i = 0;i < n;i++){
            if(map.containsKey(positions[i])){
                ans.add(map.get(positions[i]));
            }
        }
        return ans;
    }
}