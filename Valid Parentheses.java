class Solution {
    
        //Create Hash table for mappings of key(closing brace)
        //To value(opening brace)
        private HashMap<Character, Character> mappings;
        
        //Initialize hash map with mappings
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }
            
    public boolean isValid(String s) {
        
        //Initialize a stack to be used in the algorithm
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            //If the current character is a closing bracket
            if(this.mappings.containsKey(c)) {
                
                //Get top element of the stack, if empty set dummy value '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                
                //If mapping doesn't match bracket's top element return false
                if(topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                //If element was an open bracket push to stack
                stack.push(c);
            }
        }
        
        //If the stack still contains elements, then it is an invalid expression, return false
        return stack.isEmpty();
        
    }
}