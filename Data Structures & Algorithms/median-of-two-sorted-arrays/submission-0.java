class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        double median = 0;
        int sum = nums1.length + nums2.length;
        String str = "";
        
        // Edge case: if both arrays are empty
        if (sum == 0) return 0;
        
        if (sum % 2 == 0) {
            // For even length, we need to merge until we have (sum/2) + 1 elements
            int targetCount = sum / 2 + 1;
            
            while (i < nums1.length || j < nums2.length) {
                if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                    str += nums1[i] + ",";  // Add separator for multi-digit numbers
                    i++;
                } else if (j < nums2.length) {
                    str += nums2[j] + ",";
                    j++;
                }
                
                // When we've processed targetCount elements
                if (i + j == targetCount) {
                    // Split string to get numbers
                    String[] parts = str.split(",");
                    // For even: need the (targetCount-1)th and targetCountth elements
                    int a = Integer.parseInt(parts[parts.length - 2]);
                    int b = Integer.parseInt(parts[parts.length - 1]);
                    median = (a + b) / 2.0;
                    break;
                }
            }
        } else {
            // For odd length, we need to merge until we have (sum/2) + 1 elements
            int targetCount = sum / 2 + 1;
            
            while (i < nums1.length || j < nums2.length) {
                if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                    str += nums1[i] + ",";
                    i++;
                } else if (j < nums2.length) {
                    str += nums2[j] + ",";
                    j++;
                }
                
                if (i + j == targetCount) {
                    String[] parts = str.split(",");
                    median = Integer.parseInt(parts[parts.length - 1]);
                    break;
                }
            }
        }
        return median;
    }
}