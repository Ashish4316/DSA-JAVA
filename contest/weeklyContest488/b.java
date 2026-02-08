package Contest.weeklyContest488;
import java.util.*;
public class b {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            list.add((long)nums[i]);
            while(list.size() >= 2){
                int n = list.size();
                if(list.get(n-1).equals(list.get(n-2))){
                    long merged = list.get(n-1) + list.get(n-2);
                    list.remove(n-1);
                    list.remove(n-2);
                    list.add(merged);
                }else{
                    break;
                }
            }
        }
        return list;
}
