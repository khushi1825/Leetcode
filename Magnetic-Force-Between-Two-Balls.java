class Solution {
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);   
        int ans=0;

        int left=1;
        int right=position[n-1]-position[0];
        while(left<=right){
            int mid=left+(right-left)/2;
            int cows=arrange(position,mid);
            if(cows<m){
                right=mid-1;
            }
            else{
                ans=mid;
                left=mid+1;
            }
        }
        
        return ans;
    }

    int arrange(int[] stalls,int d) {
        int c=1;
        int prev=stalls[0];
        for (int i=1;i<stalls.length;i++){
            if(stalls[i]-prev>=d){
                c++;
                prev=stalls[i];
            }
        }
        return c;
    }
}