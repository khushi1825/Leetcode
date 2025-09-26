class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //Bruteforce
        // int n=nums.length;
        // int maxSum=Integer.MIN_VALUE;
        // for (int i=0;i<n;i++){
        //     int currSum=0;
        //     for (int j=i;j<n+i;j++){
        //         currSum+=nums[(j)%n];
        //         maxSum=Math.max(maxSum,currSum);
        //     }
        // }

        // return maxSum;


        // Bruteforce 
        // for(int i=0;i<n;i++){
        //     for(int j=i;;j++){
        //         sum+=nums[j];
        //         ans=Math.max(ans,sum);
        //         j=(j+1)%n;
        //         if(j==i){
        //             break;
        //         }
        //     }
        // }


        // optimal
        int ans1=maxSub(nums);
        int n=nums.length;
        int total_sum=0;
        for(int i=0;i<n;i++){
            total_sum+=nums[i];
            nums[i]=(-1)*nums[i];
        }

        int sum2=maxSub(nums);
        int ans2=total_sum+sum2;
        if(ans2==0){
            return ans1;
        }

        return Math.max(ans1,ans2);

    }

    public static int maxSub(int [] nums){
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            ans=Math.max(sum,ans);
            if(sum<0){
                sum=0;
            }
        }

        return ans;
    }
}