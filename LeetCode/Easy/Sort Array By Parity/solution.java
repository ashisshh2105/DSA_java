class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Left side par even hai → aage badho
            if (nums[left] % 2 == 0) {
                left++;
            }

            // Right side par odd hai → peeche aao
            else if (nums[right] % 2 != 0) {
                right--;
            }

            // Left par odd aur right par even → swap
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }
}