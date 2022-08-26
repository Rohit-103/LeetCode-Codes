class Solution {
public:
    int* count(int N){
        int*ans = new int[10]{0};
        while(N != 0){
            ans[N%10]++;
            N = N/10;
        }
        return ans;
    }
    bool reorderedPowerOf2(int n) {
        int j = 0;
        int*nums = count(n);
        for(int i=0;i<31;i++){
            int*arr = count(1<<i);
            for(j=0;j<10;j++){
                // cout<<arr[j]<<" "<<nums[j]<<endl;
                if(arr[j] != nums[j]) break;
            }
            if(j == 10) return true;
        }
        return false;
    }
};