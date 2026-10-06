class Solution {
    public int compress(char[] chars) {

        int index = 0;

        for (int i = 0; i < chars.length; i++) {

            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

            i--; // because for loop will increase i again

            chars[index++] = ch;

            if (count > 1) {
                String s = String.valueOf(count);

                for (int j = 0; j < s.length(); j++) {
                    chars[index++] = s.charAt(j);
                }
            }
        }

        return index;
    }
}