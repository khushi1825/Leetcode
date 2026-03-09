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
11class Solution{
12    public ListNode mergeKLists(ListNode[] lists){
13        PriorityQueue<ListNode> q=new PriorityQueue<>((a,b)->a.val-b.val);//sorting in adcending order insertion time of pq logn
14        for(ListNode h:lists){
15            if(h!=null){
16                q.add(h);
17            }
18        }
19        ListNode dummy=new ListNode();
20        ListNode tail=dummy;
21        while(!q.isEmpty()){
22            ListNode curr=q.poll();
23            tail.next=curr;
24            tail=tail.next;
25            if(curr.next!=null){
26                q.add(curr.next);
27            }
28        }
29        return dummy.next;
30    }
31}