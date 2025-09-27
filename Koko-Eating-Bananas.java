class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }

        int start=1;
        int end=max;
        int ans=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(hours(piles,mid)<=h){
                end=mid-1;
                ans=mid;
            }
            else{
                start=mid+1;
            }
        }

        return ans;
    }

    public static long hours(int [] arr,int mid){
        long sum=0;
        for(int i=0;i<arr.length;i++){          
            sum+=(arr[i]+mid-1)/mid;
        }

        return sum;
    }
}