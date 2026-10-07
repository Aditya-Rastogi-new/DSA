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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        k = k%len;
        if(k==0|| head.next == null) return head;
        temp = head;

        for(int i = 0; i<len - k - 1;i++){
            temp = temp.next;
        }
        ListNode curr = temp.next;
        temp.next = null;
        ListNode t = curr;
        while(t!= null && t.next != null){
            t = t.next;
        }
        if(t!= null) t.next = head;
        return curr;
    }
}