class Solution {
    public int lastStoneWeight(int[] stones) {
        MaxHeap heap = new MaxHeap();

        for (int stone: stones) {
            heap.insert(stone);
        }

        while (heap.size() > 1) {
            int x = heap.extractMax();
            int y = heap.extractMax();

            if (x < y) {
                heap.insert(y-x);
            } else if (y < x) {
                heap.insert(x-y);
            }
        }

        if (heap.size() == 1) return heap.extractMax();
        return 0;
    }

    class MaxHeap {
        private ArrayList<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        private int parent(int i) {
            return (i-1)/2;
        }

        private int leftChild(int i) {
            return 2*i + 1;
        }

        private int rightChild(int i) {
            return 2*i + 2;
        }

        private void swap(int val1, int val2) {
            int temp = heap.get(val1);
            heap.set(val1, heap.get(val2));
            heap.set(val2, temp);
        }

        public void insert(int value) {
            heap.add(value);
            int currentIndex = heap.size()-1;

            while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
                swap(currentIndex, parent(currentIndex));
                currentIndex = parent(currentIndex);
            }
        }

        public int extractMax() {
            int max = heap.get(0);
            int lastElement = heap.remove(heap.size()-1);

            if (!heap.isEmpty()) {
                heap.set(0, lastElement); 

                int currentIndex = 0;
                while (true) {
                    int left = leftChild(currentIndex);
                    int right = rightChild(currentIndex);

                    int largest = currentIndex;

                    if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                        largest = left;
                    }

                    if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                        largest = right;
                    }

                    if (largest == currentIndex) {
                        break; 
                    }

                    swap(currentIndex, largest); 
                
                    currentIndex = largest; 
                }
            }

            return max;
        }

        public int size() {
            return heap.size();
        }

    }
}
