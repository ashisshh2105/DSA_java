class Solution {
    public int minStartingIndex(String s, String pattern) {

        int n = s.length();
        int m = pattern.length();

        // pattern + "#" + s
        String str = pattern + "#" + s;
        int[] left = zFunction(str);

        // Reverse pattern and s
        String rp = new StringBuilder(pattern).reverse().toString();
        String rs = new StringBuilder(s).reverse().toString();

        // reversed pattern + "#" + reversed s
        String rev = rp + "#" + rs;
        int[] right = zFunction(rev);

        // Check every starting index
        for (int i = 0; i <= n - m; i++) {

            // Number of matching characters from left
            int l = left[m + 1 + i];

            // Number of matching characters from right
            int r = right[m + 1 + (n - i - m)];

            // At most one character is different
            if (l + r >= m - 1) {
                return i;
            }
        }

        return -1;
    }

    private int[] zFunction(String str) {

        int n = str.length();
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                   str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}