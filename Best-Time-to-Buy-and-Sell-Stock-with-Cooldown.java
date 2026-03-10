1class Solution{
2    public int maxProfit(int[] prices){
3        int n=prices.length;
4        int dp[][]=new int[n][2];
5        for(int i=0;i<n;i++){
6            Arrays.fill(dp[i],-1);
7        }
8        return func(prices,0,0,dp);
9    }
10
11    int func(int[] arr,int i,int buy,int[][] dp){
12        if(i>=arr.length){
13            return 0;
14        }
15        if(dp[i][buy]!=-1){
16            return dp[i][buy];
17        }
18        if(buy==0){
19            int a=func(arr,i+1,1,dp)-arr[i];
20            int b=func(arr,i+1,0,dp);
21            dp[i][buy]=Math.max(a,b);
22        }
23        else{
24            int a=func(arr,i+2,0,dp)+arr[i];
25            int b=func(arr,i+1,1,dp);
26            dp[i][buy]=Math.max(a,b);
27        }
28        return dp[i][buy];
29    }
30}