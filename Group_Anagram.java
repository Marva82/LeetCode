class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length == 0) return new ArrayList();
        
        //Creation of HashMap DS to hold count(keys) of strings
        Map<String, List> ans = new HashMap<String, List>();
        
        int[] count = new int[26];
        
        for(String s: strs) {
            Arrays.fill(count, 0); //Fill count with 26 0's for each letter
                //Convert char to ASCII value and then count it
                for(char c : s.toCharArray()) count[c - 'a']++;
                
                //sb to hold count values, delimiter character for each letter
                StringBuilder sb = new StringBuilder("");
                
                for(int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();
                
                //Insert key and List of characters into ans if it
                //doesn't already exist
                if(!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
