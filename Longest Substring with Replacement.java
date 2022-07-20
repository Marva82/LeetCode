class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # Hash map to count the occurences of each character
        count = {}
        
        # Longest substring with k replacements
        res = 0
        
        # Pointers to search through string
        left = 0 
        right = 0
        
        for right in range(len(s)):
            # Get longest of particular character, if it doesn't
            # exist return a default value of 0
            count[s[right]] = 1 + count.get(s[right], 0)
            
            # Make sure the current window size is valid
            # Subtract window size from most frequent character
            while(right - left + 1) - max(count.values()) > k:
                # Decrement count of left position
                count[s[left]] -= 1
                
                # Shift the left point over by one place
                left += 1
            
            # Get the maximum size of the window
            res = max(res, right - left + 1)
        return res