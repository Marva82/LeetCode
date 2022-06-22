class Solution {
    public int rob(int[] nums) {
        
        int N = nums.length;
        int rob1 = 0;
        int rob2 = nums[N - 1];
       
        
        
        
        for(int i = N - 2; i >= 0; --i) {
            int current = Math.max(rob2, rob1 + nums[i]);
            
            rob1 = rob2;
            rob2 = current;
        }
        
        return rob2;
        
    }
}