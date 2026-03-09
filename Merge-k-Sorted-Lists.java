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
12    public ListNode mergeKLists(ListNode[] lists) {
13        List<Integer> res=new ArrayList<>();
14        for(ListNode h:lists){
15            while(h!=null){
16                res.add(h.val);
17                h=h.next;
18            }
19        }
20        Collections.sort(res);
21        ListNode dummy=new ListNode(-1);//tail
22        ListNode curr=dummy;
23        for(int val:res){
24            curr.next=new ListNode(val);
25            curr=curr.next;
26        }
27        return dummy.next;   
28    }
29}