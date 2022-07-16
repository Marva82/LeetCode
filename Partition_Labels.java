class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] lastIndex = new int[26];
        
        for(int i = 0; i < s.length(); ++i) 
            lastIndex[s.charAt(i) - 'a'] = i;
            
        int end = 0;
        int size = 0;
            
        List<Integer> res = new ArrayList();
            
        for(int i = 0; i < s.length(); ++i) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if(i == end) {
                res.add(i - size + 1);
                size = i + 1;
            }
        }
        
        return res;
    }
}