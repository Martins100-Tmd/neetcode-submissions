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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2!=null) return list2;
        if(list1!=null && list2==null) return list1;
        if(list1==null && list2==null) return null; 
        ListNode head = null;
        if (list1.val >= list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            }
            else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;            
        }

        while (list1 != null) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }

        return head;
    }
}