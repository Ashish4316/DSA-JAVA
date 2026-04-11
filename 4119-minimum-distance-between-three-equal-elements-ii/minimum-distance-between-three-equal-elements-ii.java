class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                map.put(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(List<Integer> list : map.values()){
            if(list.size() < 3){
                continue;
            }
            int i = 0;
            int j = 1;
            int k = 2;
            answer = Math.min(answer,Math.abs(list.get(i) - list.get(j)) + Math.abs(list.get(j) - list.get(k)) + Math.abs(list.get(k) - list.get(i)));
            i = j;
            j = k;
            k = 3;
            while(k < list.size()){
                answer = Math.min(answer,Math.abs(list.get(i) - list.get(j)) + Math.abs(list.get(j) - list.get(k)) + Math.abs(list.get(k) - list.get(i)));
                i = j;
                j = k;
                k++;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}