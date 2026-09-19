class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //optimal
        int s=0;
        int end=0;
        int p=1;
        int ans=0;
        while(end<nums.length){
            p=p*nums[end];
            while(p>=k && s<=end){
                p=p/nums[s];
                s++;
            }
            ans=ans+(end-s+1);
            end++;
        }
        return ans;
        
    }
}