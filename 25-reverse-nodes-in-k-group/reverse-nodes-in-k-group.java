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
    public ListNode reverse(ListNode head,int left, int right){
        if(head == null || left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode before = dummy;
        for(int i = 1; i<left; i++){
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        int num = size/k;
        int count = 1;
        int i = 1;
        int j = k;
        while(count <= num){
            head = reverse(head,i,j);
            i += k;
            j += k;
            count++;
        }
        return head;
    }
}