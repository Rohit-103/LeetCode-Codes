class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        if(i == -1){
            reverse(nums);
            return;
        }
        int j = nums.length-1;
        while(j>i && nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j);
        Arrays.sort(nums,i+1,nums.length);
        return;
    }
    public void swap(int[] nums, int i, int j){
        nums[j] = (nums[i]+nums[j]) - (nums[i] = nums[j]);
    }
    public void reverse (int[] nums){
        int i = 0,j = nums.length-1;
        while(i<j){ 
            nums[j] = nums[i] + nums[j] - (nums[i] = nums[j]);
            i++;
            j--;
        }
    }
}