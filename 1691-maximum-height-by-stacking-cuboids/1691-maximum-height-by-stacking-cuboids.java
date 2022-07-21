class Solution {
    public int maxHeight(int[][] arr) {
        for(int[] ar: arr){
            Arrays.sort(ar);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0] == b[0]){
                if(a[1] == b[1]){
                    return a[2]-b[2];
                }
                else return a[1]-b[1];
            }
            else return a[0]-b[0];
        });
        // for(int[] ar: arr){
        //     System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);
        // }
        int[] dp = new int[arr.length];
        dp[0] = arr[0][2];
        int ans = dp[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = arr[i][2];
            for(int j=0;j<i;j++){
                if(arr[j][0]<=arr[i][0] && arr[j][1]<=arr[i][1] && arr[j][2]<=arr[i][2])
                dp[i] = Math.max(dp[i],dp[j]+arr[i][2]);
            }
            ans = Math.max(dp[i],ans);
        }
        for(int ele :dp){
            //System.out.println(ele);
        }
        return ans;
    }
}