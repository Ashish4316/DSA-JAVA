/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            ListNode temp = curr;
            curr.next = prev;
            prev = temp;

            curr = nextNode;
        }
        int ans = 0;
        while(prev != null){
            ans = Math.max(ans,prev.val + head.val);
            prev = prev.next;
            head = head.next; 
        }
        return ans;
    }
}