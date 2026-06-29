1class Solution {
2    class Node {
3        Node[] c = new Node[26];
4        Node f;
5        Node l;
6        int n = 0;
7    }
8
9    public int numOfStrings(String[] patterns, String word) {
10        Node root = new Node();
11        
12        for (int i = 0; i < patterns.length; i++) {
13            Node curr = root;
14            String p = patterns[i];
15            
16            for (int j = 0; j < p.length(); j++) {
17                int x = p.charAt(j) - 97;
18                
19                if (curr.c[x] == null)
20                    curr.c[x] = new Node();
21                    
22                curr = curr.c[x];
23            }
24            
25            curr.n++;
26        }
27        
28        Node[] q = new Node[10005];
29        int hd = 0;
30        int tl = 0;
31        
32        for (int i = 0; i < 26; i++) {
33            if (root.c[i] == null) {
34                root.c[i] = root;
35                continue;
36            }
37            
38            root.c[i].f = root;
39            root.c[i].l = null;
40            q[tl] = root.c[i];
41            tl++;
42        }
43        
44        while (hd < tl) {
45            Node curr = q[hd];
46            hd++;
47            
48            for (int i = 0; i < 26; i++) {
49                if (curr.c[i] == null) {
50                    curr.c[i] = curr.f.c[i];
51                    continue;
52                }
53                
54                curr.c[i].f = curr.f.c[i];
55                
56                if (curr.c[i].f.n == 0)
57                    curr.c[i].l = curr.c[i].f.l;
58                else
59                    curr.c[i].l = curr.c[i].f;
60                    
61                q[tl] = curr.c[i];
62                tl++;
63            }
64        }
65        
66        Node curr = root;
67        int res = 0;
68        
69        for (int i = 0; i < word.length(); i++) {
70            int x = word.charAt(i) - 97;
71            curr = curr.c[x];
72            
73            Node m = curr;
74            
75            while (m != null) {
76                res += m.n;
77                m.n = 0;
78                
79                Node tmp = m.l;
80                m.l = null;
81                m = tmp;
82            }
83        }
84        
85        return res;
86    }
87}