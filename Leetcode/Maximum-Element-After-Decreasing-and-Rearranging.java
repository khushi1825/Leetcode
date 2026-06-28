1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] A) {
3        Arrays.sort(A);
4        int n = A.length;
5
6        A[0] = 1;
7        for (int i = 1; i < n; i++)
8            A[i] = Math.min(A[i], A[i - 1] + 1);
9        
10        return A[n - 1];
11    }
12}