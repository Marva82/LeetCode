class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int res = 0;
        int left;
        int right;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(right = 0, left = 0; right < n; right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return res;
        
    }
}