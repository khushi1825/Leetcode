1class Solution {
2    class pair{
3        int x;
4        int y;
5        int cost;
6        public pair(int x, int y, int cost){
7            this.x=x;
8            this.y=y;
9            this.cost=cost;
10        }
11    }
12    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
13        int count=0;
14        int m=grid.size();
15        int n=grid.get(0).size();
16        int visit[][]=new int[m][n];
17        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
18        int src_x=0;
19        int src_y=0;
20        int dest_x=m-1;
21        int dest_y=n-1;
22        pq.add(new pair(0,0,grid.get(0).get(0)));
23        while(!pq.isEmpty()){
24            pair p=pq.poll();
25            int x=p.x;
26            int y=p.y;
27            int cost=p.cost;
28            if(visit[x][y]==1){ 
29                continue;
30            }
31            visit[x][y]=1;
32            if(x==dest_x && y==dest_y){ 
33                return cost<health;
34            }
35            int r[]={0,1,0,-1};
36            int c[]={1,0,-1,0};
37            for(int i=0;i<r.length;i++){
38                int nx=x+r[i];
39                int ny=y+c[i];
40                if(nx>=0 && ny>=0 && nx<m && ny<n && visit[nx][ny]==0){
41                    int curr=grid.get(nx).get(ny)+cost;
42                    pq.add(new pair(nx,ny,curr));   
43                }
44            }
45        }
46        return false;
47    }
48}