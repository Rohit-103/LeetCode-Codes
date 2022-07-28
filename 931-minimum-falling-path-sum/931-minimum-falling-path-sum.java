class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int left = j==0?Integer.MAX_VALUE:matrix[i+1][j-1];
                int right = ((j == n-1) ? Integer.MAX_VALUE : matrix[i+1][j+1]);
                int below = matrix[i+1][j];
                matrix[i][j] += Math.min(left,Math.min(right,below));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,matrix[0][i]);
        }
        return min;
    }
}