class KthLargest {
    private MinHeap heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new MinHeap();
        this.k = k;

        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.insert(val);

        if (heap.size() > k) {
            heap.extractMin();
        }

        return heap.peekMin();
    }

    class MinHeap {
        private ArrayList<Integer> heap;

        public MinHeap() {
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
        
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public void insert(int val) {
            heap.add(val);
            int curIndex = heap.size()-1;

            while (curIndex > 0 && heap.get(curIndex) < heap.get(parent(curIndex))) {
                swap(curIndex, parent(curIndex));
                curIndex = parent(curIndex);
            }
        }

        public int extractMin() {
            int min = heap.get(0);

            int lastElement = heap.remove(heap.size()-1);

            if (!heap.isEmpty()) {
                heap.set(0, lastElement);

                int curIndex = 0;
                while (true) {
                    int left = leftChild(curIndex);
                    int right = rightChild(curIndex);

                    int smallest = curIndex;

                    if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                        smallest = left;
                    }
                    if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                        smallest = right;
                    }

                    if (smallest == curIndex) break;
                    swap(curIndex, smallest);
                    curIndex = smallest;
                }
            }

            return min;
        }

        public int size() {
            return heap.size();
        }

        public int peekMin() {
            return heap.get(0);
        }
    }
}
