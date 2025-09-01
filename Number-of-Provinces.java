class Solution {
    private void bfs(List<List<Integer>> adj,boolean vis[],int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        vis[x]= true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            
            for(Integer it:adj.get(node)){
                if(vis[it]==false){
                    vis[it] = true;
                    q.add(it);
                }
            }
       }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                bfs(adj,vis,i);
            }
        }
        return count;
    }
}


