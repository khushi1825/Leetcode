1class Solution {
2    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
3        Arrays.sort(buses);
4        Arrays.sort(passengers);
5        Set<Integer> set = new HashSet<>();
6        int ans=0,j=0;
7        for(int i=0;i<buses.length;i++){
8            int c=0;
9            while(j<passengers.length && c<capacity && passengers[j]<=buses[i]){
10                if(!set.contains(passengers[j]-1)){
11                    ans=passengers[j]-1;
12                }
13                set.add(passengers[j]);
14                j++; 
15                c++;
16            }
17            if(c<capacity && !set.contains(buses[i])){
18                ans = buses[i];
19            }
20        }
21        return ans;
22    }
23}