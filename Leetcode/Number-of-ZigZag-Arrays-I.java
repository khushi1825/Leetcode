1class Solution {
2    private static final int MOD = 1000000007;
3
4    public int zigZagArrays(int n, int l, int r) {
5        int m = r - l + 1;
6        int[] dp = new int[m];
7        Arrays.fill(dp, 1);
8
9        for (int i = 2; i <= n; i++) {
10            int sum = 0;
11            if ((i & 1) == 0)
12                for (int j = 0; j < m; j++) {
13                    int t = dp[j];
14                    dp[j] = sum;
15                    sum = (sum + t) % MOD;
16                }
17            else
18                for (int j = m - 1; j >= 0; j--) {
19                    int t = dp[j];
20                    dp[j] = sum;
21                    sum = (sum + t) % MOD;
22                }
23        }
24
25        int res = 0;
26        for (int j = 0; j < m; j++)
27            res = (res + dp[j]) % MOD;
28
29        return (res << 1) % MOD;
30    }
31}