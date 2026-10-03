class Solution {
    public boolean detectCapitalUse(String word) {

        int count = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }

        return count == 0 ||
               count == word.length() ||
               (count == 1 && Character.isUpperCase(word.charAt(0)));
    }
}