class Solution {
    public int countPrimes(int n) {
        boolean [] p=new boolean[n+2];
        Arrays.fill(p,true);
        p[0]=false;
        p[1]=false;
        for(int i=2;i<n;i++){
            if(p[i]){
                for(int j=2;i*j<=n;j++){
                    p[i*j]=false;
                }
            }
        }

        int c=0;
        for(int i=1;i<n;i++){
            if(p[i]){
                c++;
            }
        }

        return c;
    }
}