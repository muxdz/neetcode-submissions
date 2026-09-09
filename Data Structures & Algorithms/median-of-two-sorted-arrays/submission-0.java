class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length+nums2.length;
        int middle = (total+1)/2;

        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int countA = (left+right)/2;
            int countB = middle-countA;

            int leftA = countA == 0 ? Integer.MIN_VALUE : nums1[countA-1];
            int rightA = countA == nums1.length ? Integer.MAX_VALUE : nums1[countA];
            int leftB = countB == 0 ? Integer.MIN_VALUE : nums2[countB-1];
            int rightB = countB == nums2.length ? Integer.MAX_VALUE : nums2[countB];

            if (leftA <= rightB && leftB <= rightA) {
                if (total%2 == 1) {
                    return Math.max(leftA, leftB);
                }

                return (
                    Math.max(leftA, leftB) + Math.min(rightA, rightB)
                ) / 2.0;
            }

            if (leftA > rightB) {
                right = countA-1;
            } else {
                left = countA+1;
            }
        }

        return 0;
    }
}
