1class Solution {
2    public boolean validPath(int n, int[][] edges, int source, int destination) {
3        List<List<Integer>> graph=new ArrayList<>();
4        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
5        for(int e[]:edges){
6            graph.get(e[0]).add(e[1]);
7            graph.get(e[1]).add(e[0]);
8        }
9        HashSet<Integer>vis=new HashSet<>();
10        return haspath(source,destination,vis,graph);
11    }
12
13    public boolean haspath(int src,int des,HashSet<Integer>vis,List<List<Integer>> graph){
14        if(src==des){
15            return true;
16        }
17        vis.add(src);
18        for(int nbrs:graph.get(src)){
19            if(!vis.contains(nbrs)){
20                boolean ans=haspath(nbrs,des,vis,graph);
21                if(ans){
22                    return true;
23                }
24            }
25        }
26        return false;
27    }
28}