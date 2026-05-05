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
    public ListNode rotateRight(ListNode head, int k){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == 0 || k == 0)return head;
        k = k % count;
        if(k == 0) return head;
        int pos = count - k;
        int i = 1;
        ListNode temp2 = head;
        while(i < pos){
            temp2 = temp2.next;
            i++;
        }
        ListNode prev = temp2;
        temp2 = temp2.next;
        prev.next = null;
        ListNode nH = temp2;
        while(temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = head;
        return nH;
    }
}