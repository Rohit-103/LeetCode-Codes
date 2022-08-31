class Solution {
public:
    // simple formula
    // we find leftmax and rightmax and do this minus h[i]
    // water stored above each building;
    int trap(vector<int>& height) {
        int ans = 0;
        int n = height.size();
        int right[n];
        right[n-1] = height[n-1];
        int maxx = right[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = maxx;
            maxx = max(height[i],maxx);
            // cout<<right[i]<<endl;
        }
        int leftmax = height[0];
        for(int i=1;i<n-1;i++){
            ans += max(height[i],min(leftmax, right[i])) - height[i];
            leftmax = max(leftmax,height[i]);
        }
        return ans;
    }
};