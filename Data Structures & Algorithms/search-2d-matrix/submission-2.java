class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] idx = new int[matrix[0].length];
        boolean isFound = false;
        for (int[] mat : matrix) {
            int left = mat[0];
            int right = mat[mat.length - 1];
            if (left <= target && target <= right) {
                idx = mat;
                isFound = true;
                break;
            }
        }
        if(!isFound) return false;
        Arrays.stream(idx).forEach(x -> System.out.println(x));
        for (int id : idx) {
            if (id == target)
                return true;
        }
        return false;
    }
}
