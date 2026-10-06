class Solution {

    public String removeBackspace(String s) {
        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '#') {
                if (str.length() > 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            } else {
                str.append(ch);
            }
        }

        return str.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return removeBackspace(s).equals(removeBackspace(t));
    }
}