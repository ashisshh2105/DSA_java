
import java.util.Arrays;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0, j = 0;
        int count = 0;
        int max = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
                max = Math.max(max, count);
            } else {
                count--;
                j++;
            }
        }

        return max;
    }
}
