1class Solution {
2    public int largestAltitude(int[] gain) {
3        int n = gain.length;
4        int mx = 0;
5
6        for (int i = 0; i <= n; i++) {
7            int alt = 0;
8            for (int j = 0; j < i; j++) {
9                alt += gain[j];
10            }
11            mx = Math.max(mx, alt);
12        }
13
14        return mx;
15    }
16}