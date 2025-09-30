class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        
        for (int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i), 0)+1);
        }
        
        if (map1.equals(map2)){
            return true;
        }
        
        int left=0;
        for (int right=s1.length();right<s2.length();right++){
            char ch1=s2.charAt(right);
            map2.put(ch1,map2.getOrDefault(ch1,0)+1);
            
            char ch2=s2.charAt(left);
            map2.put(ch2,map2.get(ch2)-1);
            if (map2.get(ch2)==0){
                map2.remove(ch2);
            }
            
            left++;
            
            if (map1.equals(map2)){
                return true;
            }
        }
        
        return false;        
    }
}