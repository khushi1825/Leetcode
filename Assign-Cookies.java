class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start=0;
        int end=0;
        int c=0;
        while(start<g.length && end<s.length){
            if(s[end]>=g[start]){
                start++;
                end++;
                c++;
            }
            else{
                end++;
            }
        
        }

        return c;
    }
}