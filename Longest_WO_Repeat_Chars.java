class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int res = 0;
        int left;
        int right;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0, left = 0; right < n; right++) {
            if(map.containsKey(s.charAt(right))) {
                //Removes the left most character since it is a duplicate
                //Increment the left pointer for sliding window
                left = Math.max(map.get(s.charAt(right)), left);
            }
            
            //Add right most character to the set
            map.put(s.charAt(right), right + 1);
            //Update the results variable if the current window size is greater than previous window
            res = Math.max(res, right - left + 1);
        }
        return res;
        
    }
}