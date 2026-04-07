1class Solution {
2    public int prefixCount(String[] words, String pref) {
3        int c=0;
4        for(String w:words) if(w.startsWith(pref)) c++;
5        return c;
6    }
7}