class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int leftmax=0;
        int rightmax=0;
        int sum=0;
        while(left<=right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=leftmax){
                    leftmax=arr[left];
                }
                else{
                    sum+=leftmax-arr[left];
                }
                left++;
            }
            else{
                if(arr[right]>=rightmax){
                    rightmax=arr[right];
                }
                else{
                    sum+=rightmax-arr[right];
                }
                right--;
            }
        }
        return sum;
    }
}


/*I can optimize the prefix-suffix approach using two pointers. I maintain a left pointer and a right pointer, along with leftMax and rightMax. At every step, I compare the heights at the two pointers. If the left height is smaller, I process the left side because the right boundary is guaranteed to be at least as high. I calculate water using leftMax - arr[left] and move the left pointer. Otherwise, I process the right side using rightMax - arr[right]. This eliminates the two auxiliary arrays, so the time complexity remains O(n), but the space complexity becomes O(1).*/