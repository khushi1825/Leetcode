1class Solution {
2    public int countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int ans = 0;
5
6        for (int l = 0; l < n; l++) {
7            int targetCount = 0;
8
9            for (int r = l; r < n; r++) {
10                if (nums[r] == target) {
11                    targetCount++;
12                }
13
14                int len = r - l + 1;
15
16                if (targetCount > len / 2) {
17                    ans++;
18                }
19            }
20        }
21
22        return ans;
23    }
24}