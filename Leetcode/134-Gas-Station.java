class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //optimise
        int n=gas.length;
        int totalG=0;
        int totalC=0;
        int start=0;
        int currG=0;
        for(int i=0;i<n;i++){
            totalG+=gas[i];
            totalC+=cost[i];
            currG+=(gas[i]-cost[i]);
            if(currG<0){
                start=i+1; // choose next index as prev is eliminated
                currG=0;
            }
        }
        if(totalG < totalC){ // solution does not exist for this
            return -1;
        }
        return start;
    }
}