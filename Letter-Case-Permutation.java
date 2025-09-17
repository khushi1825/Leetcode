class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, "", list);
        return list;
    }

    public static void helper(String s, int index, String ans, List<String> list) {
        if (index == s.length()) {
            list.add(ans);
            return;
        }

        char ch = s.charAt(index);

        if (Character.isDigit(ch)) {
            helper(s, index + 1, ans + ch, list);
        } else {
            helper(s, index + 1, ans + Character.toLowerCase(ch), list);
            helper(s, index + 1, ans + Character.toUpperCase(ch), list);
        }
    }
}
