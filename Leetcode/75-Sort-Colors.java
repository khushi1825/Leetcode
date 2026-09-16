class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int i=0;
        int left=0;
        int right=n-1;
        while(i<=right){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                i++;
                left++;
            }
            else if(nums[i]==1){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
    }
}