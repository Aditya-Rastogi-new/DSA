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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        for(int i = 1; i< left; i++){
            before = before.next;
        }
        ListNode curr = before.next, prev = null;
        for(int i = 0; i<=right - left; i++){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        before.next.next = curr;
        before.next = prev;
        return dummy.next;
    }
}