class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length){
            return -1;
        }
        int left=1;
        int right=0;
        int ans=-1;
        for(int i:bloomDay){
            right=Math.max(right,i);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int b=flowers(bloomDay,k,mid);
            if(b>=m){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }

    int flowers(int []arr,int k,int d){
        int b=0;
        int f=0;
        for(int i:arr){
            if(i<=d){
                f++;
                if(f==k){
                    b++;
                    f=0;
                }
            }
            else{ 
                f=0;
            }
        }
        return b;

    }
}