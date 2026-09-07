class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int middle = (left+right)/2;
        int[] potentialRow = null;

        while (left <= right) {
            middle = (left+right)/2;
            int leftVal = matrix[middle][0];
            int rightVal = matrix[middle][matrix[middle].length-1];
            if ((leftVal <= target) && (target <= rightVal)) {
                potentialRow = matrix[middle];
                break;
            }
            else if (leftVal > target) {
                right = middle-1;
            }
            else {
                left = middle+1;
            }
        }

        if (potentialRow == null) return false;

        left = 0;
        right = potentialRow.length-1;

        while (left <= right) {
            middle = (left+right)/2;
            int val = potentialRow[middle];
            if (val == target) return true;
            else if (val > target) {
                right = middle-1;
            }
            else {
                left = middle+1;
            }
        }

        return false;
    }
}
