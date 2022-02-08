package problems;

public class RemoveNthNodeFromEndOfList {
    //19 //todo not clear
    public static void main(String[] args) {
        ListNode head0 = new ListNode(3);
        ListNode head1 = new ListNode(2, head0);
        ListNode head = new ListNode(1, head1);

        int n = 1;

        ListNode result = removeNthFromEnd(head, n);
        System.out.println(result.val);
        System.out.println(result.next.val);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    Approach 2: One pass algorithm
Algorithm - two pointers.
The first pointer advances the list by n+1 steps from the beginning, while the second pointer starts from the beginning of the list.
Now, both pointers are exactly separated by n nodes apart.
We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node.
The second pointer will be pointing at the nth node counting from the last.
We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
/*
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []
 */