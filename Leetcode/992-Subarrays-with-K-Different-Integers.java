class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
    }

    public static int func(int [] nums,int k){
        int n=nums.length;
        int si=0;
        int ei=0;
        int uniq=0;
        int c=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(ei<n){
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
            if(map.get(nums[ei])==1){
                uniq++;
            }
            while(uniq>k){
                map.put(nums[si],map.get(nums[si])-1);
                if(map.get(nums[si])==0){
                    uniq--;
                }
                si++;
            }
            c+=(ei-si+1);
            ei++;
        }
        return c;
    }
} 