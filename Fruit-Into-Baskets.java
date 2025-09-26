class Solution {
    public int totalFruit(int[] fruits) {
        //bruteforce
        // int n=fruits.length;
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     //HashSet<Integer> set=new HashSet<>();
        //     int [] fr=new int [100001];
        //     int unique=0;
        //     int j=i;
        //     //int c=0;
        //     for(j=i;j<n;j++){
        //         int f=fruits[j];
        //         if(fr[f]==0){
        //             unique++;
        //         }
        //         fr[f]++;
        //         // set.add(fruits[j]);
        //         // if(set.size()>2){
        //         //     break;
        //         // }
        //         // c++;

        //         if(unique>2){
        //             break;
        //         }
        //     }
        //     max=Math.max(max,j-i);
        // }

        // return max;

        int n=fruits.length;
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        int fr[]=new int[100001];
        int unique=0;
        while(end<n){
            int f=fruits[end];
            if(fr[f]==0){
                unique++;
            }

            fr[f]++;
            end++;

            while(start<end && unique>2){
                int st=fruits[start];
                fr[st]--;
                if(fr[st]==0){
                    unique--;
                }

                start++;
            }
            max=Math.max(max,end-start);
        }

        return max;
    }
}