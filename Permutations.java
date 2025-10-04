class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i:nums){
            temp.add(i);
        }

        helper(temp,ans,new ArrayList<>());
        return ans;
    }

    static void helper(List<Integer> temp,List<List<Integer>> ans,List<Integer> p){
        if(temp.size()==0){
            ans.add(new ArrayList<>(p));
            System.out.println(p);
            return;
        }
        for(int i=0;i<temp.size();i++){
            int num=temp.get(i);
            p.add(num);
            temp.remove(i);
            helper(temp,ans,p);
            temp.add(i,num);
            p.remove(p.size()-1);
        }
    }   
}