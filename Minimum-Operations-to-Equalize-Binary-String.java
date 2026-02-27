1class Solution {
2    public int minOperations(String s, int k) {
3        int zero=0;
4        int len=s.length();
5        for (int i = 0; i < len; i++)
6            zero += ~s.charAt(i) & 1;
7        if (zero == 0)
8            return 0;
9        if (len == k)
10            return (zero == len ? 1 : -1);
11        int base = len - k;
12        int odd = Math.max(
13            (zero + k - 1) / k,
14            (len - zero + base - 1) / base
15        );
16        odd += ~odd & 1;
17        int even = Math.max(
18            (zero + k - 1) / k,
19            (zero + base - 1) / base
20        );
21        even += even & 1;
22        int res = Integer.MAX_VALUE;
23        if ((k & 1) == (zero & 1))
24            res = Math.min(res, odd);
25        if ((~zero & 1) == 1)
26            res = Math.min(res, even);
27        return res == Integer.MAX_VALUE ? -1 : res;
28    }
29}