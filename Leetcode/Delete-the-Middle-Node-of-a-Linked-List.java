1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12
13    static class NodeRef {
14        ListNode node;
15    }
16
17    public ListNode deleteMiddle(ListNode head) {
18        if (head.next == null) {
19            return null;
20        }
21
22        NodeRef ref = new NodeRef();
23        ref.node = head;
24
25        delet(ref, head);
26
27        return ref.node;
28    }
29
30    void delet(NodeRef head, ListNode h) {
31
32        if (h == null || h.next == null) {
33            head.node = head.node.next;
34        } else {
35            NodeRef nextRef = new NodeRef();
36            nextRef.node = head.node.next;
37
38            delet(nextRef, h.next.next);
39            head.node.next = nextRef.node;
40        }
41    }
42}