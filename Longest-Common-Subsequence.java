class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //tabulation
        int m=text1.length();
        int n=text2.length();
        //int dp[][]=new int[m+1][n+1];
        int dp[]=new int[n+1];
        for(int i=1;i<=m;i++){
            int prevDiag=0;
            for(int j=1;j<=n;j++){
                int t=dp[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //dp[i][j]=dp[i-1][j-1]+1;
                    dp[j]=1+prevDiag;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                prevDiag=t;
            }
            
        }

        return dp[n];
    }
}