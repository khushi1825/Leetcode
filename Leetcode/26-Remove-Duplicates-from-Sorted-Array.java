class Solution {
    public int removeDuplicates(int[] arr) {
        int n=arr.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }
}

/*Since the array is sorted, all duplicate elements are next to each other. I use two pointers. i keeps track of the position of the last unique element, while j scans the array. Whenever arr[j] is different from arr[i], I have found a new unique element, so I place it at i+1 and increment i */