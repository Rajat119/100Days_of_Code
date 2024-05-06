class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode reversedHead = reverseList(head);

        ListNode current = reversedHead;
        int maxValue = Integer.MIN_VALUE;
        ListNode prev = null;

        while (current != null) {
            if (current.val < maxValue) {
                prev.next = current.next;
            } else {
                maxValue = current.val;
                prev = current;
            }
            current = current.next;
        }

        return reverseList(reversedHead);
    }
}