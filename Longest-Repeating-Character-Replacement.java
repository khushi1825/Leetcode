class Solution {
    public int characterReplacement(String s, int k) {
        int start=0;
        int end=0;
        int n=s.length();
        int max=0;
        int ans=0;
        int [] freq=new int[26];
        while(end<n){
            char ch=s.charAt(end);
            freq[ch-'A']++;
            max=Math.max(max,freq[ch-'A']);
            while((end-start+1)-max>k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            ans=Math.max(ans,end-start+1);
            end++;
        }

        return ans;
    }
}