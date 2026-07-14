class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){
            int fuel=0;
            boolean possible=true;
            for(int j=0;j<n;j++){
                int idx=(i+j)%n;// for circular traversal
                fuel=fuel+gas[idx]-cost[idx];
                if(fuel<0){
                    possible=false;
                    break;
                }
            }
            if(possible){
                return i;
            }
        }
        return -1;
    }
}