class Solution {
    public int search(int[] nums, int target) {
        int ans=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                ans=i;
                break;
            }
        }

        return ans;
    }
}