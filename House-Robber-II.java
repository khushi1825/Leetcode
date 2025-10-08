class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        } 
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }


        int[] res=new int[n];
        res[0]=nums[0];
        res[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n-1;i++){
            res[i]=Math.max(res[i-2]+nums[i],res[i-1]);
        }
        int one= res[n-2];


        int[] res1=new int[n];
        res1[1]=nums[1];
        res1[2]=Math.max(nums[1],nums[2]);
        for(int i=3;i<n;i++){
            res1[i]=Math.max(res1[i-2]+nums[i],res1[i-1]);
        }
        int two=res1[n-1];


        return Math.max(one,two);
    }
}