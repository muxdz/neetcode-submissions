class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int speed = 0;

        while (low <= max) {
            speed = (low+max)/2;
            long total = 0;
            for (int pile: piles) {
                total += pile/speed;
                if (pile%speed != 0) total += 1;
            }
            if (total > h) {
                low = speed+1;
            }
            else {
                max = speed-1;
            }
        }

        return low;
    }
}
