package problems;

public class MiddleOfTheLinkedList {
    //876
    public static void main(String[] args) {
        ListNode head0 = new ListNode(5);
        ListNode head1 = new ListNode(4, head0);
        ListNode head2 = new ListNode(3, head1);
        ListNode head3 = new ListNode(2, head2);
        ListNode head = new ListNode(1, head3);

        ListNode result = middleNodeFastAndSlowPointer(head);
    }

    /*
    Approach 1: Output to Array
Intuition and Algorithm
Put every node into an array A in order. Then the middle node is just A[A.length // 2], since we can retrieve each node by index.
We can initialize the array to be of length 100, as we're told in the problem description that the input contains between 1 and 100 nodes.
     */
    public static ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /*
    Approach 2: Fast and Slow Pointer
Intuition and Algorithm
When traversing the list with a pointer slow, make another pointer fast that traverses twice as fast.
When fast reaches the end of the list, slow must be in the middle.
     */
    public static ListNode middleNodeFastAndSlowPointer(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
}

/*
Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */