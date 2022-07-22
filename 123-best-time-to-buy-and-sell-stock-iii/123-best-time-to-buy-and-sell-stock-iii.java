class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int leftmin = nums[0];
        left[0] = 0;
        int[] right = new int[n];
        int rightmax = nums[n-1];
        right[n-1] = 0;
        // leftmin and rightmax
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],nums[i]-leftmin);
            leftmin = Math.min(leftmin,nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],rightmax - nums[i]);
            rightmax = Math.max(rightmax,nums[i]);
        }
        int ans = 0;
        for(int i=0;i<=n;i++){
            ans = Math.max(ans,(i==0?0:left[i-1]) + (i==n?0:right[i]));
        }
        // for(int ele : right) System.out.print(ele);
        // System.out.println();
        // for(int ele : left) System.out.print(ele);
        return ans;
    }
}