1class Solution {
2    public boolean lemonadeChange(int[] bills) {
3        int five=0;
4        int ten=0;
5        for (int x:bills){
6            if(x==5){
7                five++;
8            } 
9            else if(x==10){
10                if (five>0){
11                    five--;
12                    ten++;
13                } 
14                else{
15                    return false;
16                }
17            } 
18            else {
19                if(five>0 && ten>0){
20                    five--;
21                    ten--;
22                } 
23                else if(five>2){
24                    five-=3;
25                } 
26                else {
27                    return false;
28                }
29            }
30        }
31
32        return true;
33    }
34}