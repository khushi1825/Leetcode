1class Solution {
2    public int[] productExceptSelf(int[] arr) {
3        int n=arr.length;
4        int [] left=new int[n];
5        left[0]=1;
6        for(int i=1;i<n;i++){
7            left[i]=left[i-1]*arr[i-1];
8        }
9        int right[]=new int[n];
10        right[n-1]=1;
11        for(int i=n-2;i>=0;i--){
12            right[i]=right[i+1]*arr[i+1];
13        }
14
15        for(int i=0;i<n;i++){
16            left[i]=left[i]*right[i];
17        }
18        return left;
19    }
20}