class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        helper(n,0,0,"",list);
        return list;
    }

    public static void helper(int n,int open,int close,String ans, List<String> list){
        if(open==n && close==n){
            list.add(ans);
            return;
        }

        if(open<n){
            helper(n,open+1,close,ans+"(",list);
        }
        
        if(close<open){
            helper(n,open,close+1,ans+")",list);
        }
    }
}