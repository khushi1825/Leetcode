1class Solution {
2    public boolean judgeCircle(String moves) {
3        int c1=0;
4        int c2=0;
5        for(int i=0;i<moves.length();i++){
6            if(moves.charAt(i)=='R') c1++;
7            if(moves.charAt(i)=='L') c1--;
8            if(moves.charAt(i)=='U') c2++; 
9            if(moves.charAt(i)=='D') c2--;
10        }
11        return c1==0 && c2==0;
12    }
13}