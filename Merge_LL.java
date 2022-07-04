class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        //dummy is pointing at the last node or empty list
        ListNode dummy = new ListNode(-1);
        //Use tail to connect nodes in proper order
        ListNode tail = dummy;
            
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        //Returns entire portion of remaining list
        tail.next = l1 == null ? l2 : l1; 
        
        //dummy.next will wrap around list from last node to first node 
        //or head of list
        return dummy.next;
    }
    
}