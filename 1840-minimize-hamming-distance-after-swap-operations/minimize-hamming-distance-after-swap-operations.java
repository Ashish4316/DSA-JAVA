class DSU{
    int [] parent;
    int [] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
    }
    int find(int node){
        if(parent[node] == node) return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }
    void union(int a,int b){
        int upA = find(a);
        int upB = find(b);
        if(upA == upB) return;
        if(rank[upA] > rank[upB]){
            parent[upB] = upA;
        }else if(rank[upB] > rank[upA]){
            parent[upA] = upB;
        }else{
            parent[upA] = upB;
            rank[upB]++;
        }
    }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for(int[] e : allowedSwaps){
            dsu.union(e[0], e[1]);
        }
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int p = dsu.find(i);
            map.putIfAbsent(p, new HashMap<>());
            map.get(p).put(source[i], map.get(p).getOrDefault(source[i], 0) + 1);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            int p = dsu.find(i);
            if(map.get(p).getOrDefault(target[i], 0) > 0){
                map.get(p).put(target[i], map.get(p).get(target[i]) - 1);
            }else{
                count++;
            }
        }
        return count;
    }
}