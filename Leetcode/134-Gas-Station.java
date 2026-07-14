class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //optimise
        int n=gas.length;
        int totalG=0;
        int totalC=0;
        for(int val:gas){
            totalG+=val;
        }
        for(int val:cost){
            totalC+=val;
        }
        if(totalG < totalC){ // solution does not exist for this
            return -1;
        }
        int start=0;
        int currG=0;
        for(int i=0;i<n;i++){
            currG+=(gas[i]-cost[i]);
            if(currG<0){
                start=i+1; // choose next index as prev is eliminated
                currG=0;
            }
        }
        return start;
        // more optimise in next
    }
}