package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class minimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        if(n == 1){
            return Arrays.asList(0);
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<>());
        }
        int [] inDegree = new int [n];
        for(int [] e : edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(inDegree[i] == 1){
                q.offer(i);
            }
        }
        while(n > 2){
            int size = q.size();
            n = n - size;
            while(size-- > 0){
                int u = q.poll();
                for(int v : graph.get(u)){
                    inDegree[v]--;
                    if(inDegree[v] == 1){
                        q.offer(v);
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            answer.add(node);
        }
        return answer;
    }
}
