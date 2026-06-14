import java.util.*;

class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for(int i = 0; i < n; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            HashMap<Integer,Integer> cnt = new HashMap<>();
            for(int k = i; k < n; k++){
                int oldFreq = map.getOrDefault(nums[k], 0);
                if(oldFreq > 0){
                    cnt.put(oldFreq, cnt.get(oldFreq) - 1);
                    if(cnt.get(oldFreq) == 0){
                        cnt.remove(oldFreq);
                    }
                }
                int newFreq = oldFreq + 1;
                map.put(nums[k], newFreq);
                cnt.put(newFreq, cnt.getOrDefault(newFreq, 0) + 1);
                if(map.size() == 1){
                    ans = Math.max(ans, k - i + 1);
                }
                else if(cnt.size() == 2){
                    int a = 0;
                    int b = 0;
                    for(int f : cnt.keySet()){
                        if(a == 0){
                            a = f;
                        }
                        else{
                            b = f;
                        }
                    }
                    if(a > b){
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    if(b == 2 * a){
                        ans = Math.max(ans, k - i + 1);
                    }
                }
            }
        }
        return ans;
    }
}