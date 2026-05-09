class Solution {
    public boolean[] seive(int maxVal){
        boolean [] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2;i*i <= maxVal;i++){
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        HashSet<Integer> isPresent = new HashSet<>();
        int maxVal  = 0;
        for(int num : nums){
            isPresent.add(num);
            maxVal = Math.max(maxVal,num);
        }
        boolean [] isPrime = seive(maxVal);

        Map<Integer, List<Integer>> numberToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numberToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int totalNodes = 2*n + 15;
        
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0;i < totalNodes;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 1;i <= n-2;i++){
            adjList.get(i).add(new int [] {i-1,1});
            adjList.get(i).add(new int [] {i+1,1});
        }
        if(n >= 2){
            adjList.get(0).add(new int [] {1,1});
            adjList.get(n-1).add(new int [] {n-1,1});
        }
        int currGodNode = n;

        for(int prime = 2;prime <= maxVal;prime++){
            if(isPrime[prime] && isPresent.contains(prime)){
                int godNode = currGodNode++;
                for(int idx : numberToIndices.get(prime)){
                    adjList.get(idx).add(new int [] {godNode,0});

                }
                for(int multi = prime;multi <= maxVal;multi += prime){
                    if(numberToIndices.containsKey(multi)){
                        for(int idx : numberToIndices.get(multi)){
                            adjList.get(godNode).add(new int [] {idx,1});
                        }
                    }
                }
            }
        }

        int [] dist = new int[totalNodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        LinkedList<Integer> q = new LinkedList<>();
        
        dist[0] = 0;

        q.addFirst(0);
 
        while(q.size() > 0){
            int u = q.removeFirst();

            for(int [] nbrs : adjList.get(u)){
                int v = nbrs[0];
                int wt = nbrs[1];

                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    if(wt == 0){
                        q.addFirst(v);
                    }else{
                        q.addLast(v);
                    }
                }
            }
        }
        return dist[n-1];
    }
}