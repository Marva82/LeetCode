class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        #hashmap to count occurences of values input array
        count = {}
        
        #Array used to store frequency of input elements
        freq = [[] for i in range(len(nums) + 1)]
        
        #Storing the values in count
        for n in nums:
            count[n] = 1 + count.get(n,0)
        
        #Returning the key, value pair that was added to dictionary
        #append key value of n, c number of times
        for n, c in count.items():
            freq[c].append(n)
            
        res = []
        
        #Iterate thru array in descending order
        for i in range(len(freq) - 1, 0, -1):
            #Go thru every sublist, could contain multiple values
            for n in freq[i]:
                res.append(n)
                #Gauranteed to have k number of values
                if len(res) == k:
                    return res