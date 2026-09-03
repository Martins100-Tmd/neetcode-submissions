class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int i = 0;
        while (left < right) {
            int mid = (int)Math.floor((right + left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target)
                return mid;
        }
        return -1;
    }
}
