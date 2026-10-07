class MedianFinder {
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    public MedianFinder() {
        high = new PriorityQueue<>();
        low = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());

        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }
    
    public double findMedian() {
        if (high.size() < low.size()) {
            return (double) low.peek();
        }

        return ((double) high.peek() + low.peek()) / 2.0;
    }
}
