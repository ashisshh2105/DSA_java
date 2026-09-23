class Solution {
    public int majorityElement(int[] nums) {
        int m=0;
        int n=0;
        for (int i=0;i<nums.length;i++){
            if (n==0){
                m=nums[i];
            }
            if (nums[i]==m){
                n++;
            }else{
                n--;
            }
        }
        return m;
    }
}