class Solution {
    public int majorityElement(int[] nums) {
        //Moore's Voting algo
        int n=nums.length;
        int ele=nums[0];
        int c=0;
        for(int i=0;i<n;i++){
            if(c==0){
                c=1;
                ele=nums[i];
            }
            else if(nums[i]==ele){
                c++;
            }
            else{
                c--;
            }
        }
        int c1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                c1++;
            }
        }
        if(c1>n/2){
            return ele;
        }
        return -1;
    }
}