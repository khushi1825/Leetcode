import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        
        if (p.length()>s.length()){
            return res;
        }
        
        HashMap<Character,Integer> map1=new HashMap<>(); 
        HashMap<Character,Integer> map2=new HashMap<>();
        
        for (int i=0;i<p.length();i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
        }
        
        if (map1.equals(map2)){
            res.add(0);
        }
        
        int left=0;
        for (int right=p.length();right<s.length();right++){
            char ch1=s.charAt(right);
            map2.put(ch1,map2.getOrDefault(ch1,0)+1);
            
            char ch2=s.charAt(left);
            map2.put(ch2,map2.get(ch2)-1);
            if (map2.get(ch2)==0){
                map2.remove(ch2);
            }
            
            left++;
            
            if (map1.equals(map2)) {
                res.add(left);
            }
        }
        
        return res;
    }
}
