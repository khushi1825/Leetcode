1class Solution {
2    public String minWindow(String s, String t) {
3        int n=s.length();
4        int m=t.length();
5        int si=0;
6        int ei=0;
7        int c=0;
8        int freq[]=new int[256];
9        int sIdx=-1;
10        int minlen=Integer.MAX_VALUE;
11        for(int i=0;i<m;i++){
12            char ch=t.charAt(i);
13            freq[ch]++;
14        }
15        while(ei<n){
16            char ch=s.charAt(ei);
17            if(freq[ch]>0){
18                c++;
19            }
20            freq[ch]--;
21            while(c==m){
22                if(minlen>ei-si+1){
23                    minlen=ei-si+1;
24                    sIdx=si;
25                }
26                char ch2=s.charAt(si);
27                freq[ch2]++;
28                if(freq[ch2]>0){
29                    c--;
30                }
31                si++;
32            }
33            ei++;
34        }
35        return sIdx==-1?"":s.substring(sIdx,sIdx+minlen);
36    }
37}
38