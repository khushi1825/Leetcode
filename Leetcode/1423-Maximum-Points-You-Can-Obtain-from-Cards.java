class Solution {
    public int maxScore(int[] card, int k) {
        //bruteforce
        int n=card.length;
        int ans=0;
        for(int left=0;left<=k;left++){
            int sum=0;
            for(int i=0;i<left;i++){//for picking left cards
                sum+=card[i];
            }
            for(int i=0;i<k-left;i++){//for picking right cards
                sum+=card[n-1-i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}