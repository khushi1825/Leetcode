class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int maxsum=kadane(nums);
        int total_sum=0;
        for(int i=0;i<n;i++){
            total_sum+=nums[i];
            nums[i]=(-1)*nums[i];
        }
        int minsum=kadane(nums);
        int ans=Math.max(maxsum,total_sum+minsum);
        if(ans==0){
            return maxsum;
        }
        return ans;
    }

    public static int kadane(int [] nums){
        int n=nums.length;
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}