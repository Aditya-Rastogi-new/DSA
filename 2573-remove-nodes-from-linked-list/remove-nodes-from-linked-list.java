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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int maxValue = curr.val;
        while(curr != null && curr.next != null){
            if(curr.next.val < maxValue){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
                maxValue = curr.val;
            }
        }
        return reverse(head);
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
}