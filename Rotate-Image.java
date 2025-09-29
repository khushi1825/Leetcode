class Solution {
    public void rotate(int[][] matrix) {

        //Bruteforce
        int n=matrix.length;
        // int [][] temp=new int[n][n];
        // for (int i=0;i<n;i++){
        //     for (int j=0;j<n;j++){
        //         temp[j][n-1-i]=matrix[i][j];
        //     }
        // }
        // for (int i=0;i<n;i++){
        //     for (int j=0;j<n;j++){
        //         matrix[i][j]=temp[i][j];
        //     }
        // }


        //optimal -> transpose then replace
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int k=0;k<n;k++){
            int i=0;
            int j=n-1;
            while(i<j){
                int temp=matrix[k][i];
                matrix[k][i]=matrix[k][j];
                matrix[k][j]=temp;
                i++;
                j--;
            }
        }

        

        
    }
}