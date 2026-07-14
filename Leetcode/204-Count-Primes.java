class Solution {
    public int countPrimes(int n) {
        //optimised
        boolean [] p=new boolean[n+2];//n+2 bcs if n==0 then p[0],p[1]=false will give error 
        Arrays.fill(p,true);
        p[0]=false;
        p[1]=false;
        int c=0;
        for(int i=2;i<n;i++){
            if(p[i]){
                c++;
                for(int j=2;i*j<n;j++){
                    p[i*j]=false;
                }
            }
        }
        return c;
    }
}