1class Solution {
2    public int numberOfSubstrings(String s) {
3        int n=s.length();
4        int lastseen[]=new int[3];
5        int c=0;
6        for(int i=0;i<3;i++){
7            lastseen[i]=-1;
8        }
9        for(int i=0;i<n;i++){
10            lastseen[s.charAt(i)-'a']=i;
11            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
12                c=c+(1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2])));
13            }
14        }
15        return c;
16    }
17}