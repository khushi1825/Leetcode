1class Solution {
2    public int maxBuilding(int num, int[][] restrictions) {
3        List<int[]> r = new ArrayList<>(Arrays.asList(restrictions));
4        r.add(new int[]{1, 0});
5        r.sort((a, b) -> Integer.compare(a[0], b[0]));
6        int n = r.size();
7
8        for (int i = 1; i < n; i++)
9            r.get(i)[1] = yCap(r.get(i - 1), r.get(i));
10
11        for (int i = n - 2; i >= 0; i--)
12            r.get(i)[1] = yCap(r.get(i + 1), r.get(i));
13
14        int res = 0;
15        for (int i = 1; i < n; i++)
16            res = Math.max(res, yPeak(r.get(i - 1), r.get(i)));
17
18        return Math.max(res, r.get(n - 1)[1] + num - r.get(n - 1)[0]);
19    }
20
21    int yCap(int[] l, int[] b) {
22        return Math.min(b[1], l[1] + Math.abs(b[0] - l[0]));
23    }
24
25    int yPeak(int[] l, int[] b) {
26        return (l[1] + b[1] + b[0] - l[0]) >> 1;
27    }
28}