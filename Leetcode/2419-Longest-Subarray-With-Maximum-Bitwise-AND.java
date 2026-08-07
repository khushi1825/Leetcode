class Solution {
    public int longestSubarray(int[] nums) {
        //optimised
        //Bitwise AND can only turn bits off, so the AND of a subarray cannot exceed any element in that subarray. Therefore, the maximum possible AND is the maximum element of the entire array. To obtain that AND, every element in the subarray must equal the maximum element, so we simply find the longest consecutive run of that value.
        int n=nums.length;
        int max=0;
        for(int num:nums) max=Math.max(max,num);
        int c=0;
        int len=0;
        for(int num:nums){
            if(num==max){
                c++;
                len=Math.max(len,c);
            }
            else{
                c=0;//breaks consecutive sequence
            }
        }
        return len;
    }
}