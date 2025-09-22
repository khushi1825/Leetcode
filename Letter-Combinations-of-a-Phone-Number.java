class Solution {

    static String  map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        combinations(digits,"",list);
        return list;

    }

    public static void combinations(String digits,String ans,List<String> list){
        if(digits.length()==0){
            list.add(ans);
            return;
        }

        char ch=digits.charAt(0);
        int num=ch-'0';
        String press=map[num];
        for(int i=0;i<press.length();i++){
            combinations(digits.substring(1),ans+press.charAt(i),list);
        }
    }
}