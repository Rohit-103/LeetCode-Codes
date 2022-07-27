class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(matrix[0][i] != '0'){ans = 1; break;}
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0] != '0'){ans = 1; break;}
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]-'0' != 0){
                    int temp = Math.min(matrix[i-1][j-1]-'0',Math.min(matrix[i-1][j]-'0',matrix[i][j-1]-'0'))+1;
                    matrix[i][j] = (char)(temp + '0');
                    ans = Math.max(matrix[i][j]-'0',ans);
                }
            }
        }
        return ans*ans;
    }
}