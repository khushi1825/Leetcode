class Solution {
    public boolean isAnagram(String s, String t) {
       HashMap<Character,Integer> map1=new HashMap<>();
       HashMap<Character,Integer> map2=new HashMap<>();
       if(s.length()!=t.length()) return false;
       for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            map1.put(ch1,map1.getOrDefault(ch1,0)+1);
            map2.put(ch2,map2.getOrDefault(ch2,0)+1);
       }
       for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map1.get(ch).equals(map2.get(ch))) return false;
       }
       return true;



    }
}