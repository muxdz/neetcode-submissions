class Solution {
    public int[][] kClosest(int[][] points, int k) {
        MaxHeap heap = new MaxHeap();

        for (int[] point: points) {
            heap.insert(point);
            if (heap.size() > k) {
                heap.removeMax();
            }
        }

        int[][] closest = new int[k][2];
        for (int i=0; i<k; i++) {
            closest[i] = heap.removeMax();
        }

        return closest;
    }

    class MaxHeap {
        private ArrayList<int[]> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        private int distance(int[] coords) {
            int pow1 = (int) Math.pow(coords[0], 2);
            int pow2 = (int) Math.pow(coords[1], 2);
            return pow1+pow2;
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
            int[] temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public void insert(int[] value) {
            heap.add(value);
            int curIndex = heap.size() - 1;

            while (curIndex > 0 
                && distance(heap.get(curIndex)) > distance(heap.get(parent(curIndex)))) {
                    swap(curIndex, parent(curIndex));
                    curIndex = parent(curIndex);
            }
        }

        public int[] removeMax() {
            int[] max = heap.get(0);
            int[] lastElement = heap.remove(heap.size()-1);

            int curIndex = 0;
            if (!heap.isEmpty()) {
                heap.set(0, lastElement);

                while (true) {
                    int leftIndex = leftChild(curIndex);
                    int rightIndex = rightChild(curIndex);

                    int largest = curIndex;

                    if (leftIndex < heap.size() 
                        && distance(heap.get(leftIndex)) > distance(heap.get(largest))) {
                            largest = leftIndex;
                        }

                    if (rightIndex < heap.size() 
                        && distance(heap.get(rightIndex)) > distance(heap.get(largest))) {
                            largest = rightIndex;
                        }

                    if (largest == curIndex) break;

                    swap(curIndex, largest);
                    curIndex = largest;
                }
                
            }
            return max;
        }

        public int size() {
            return heap.size();
        }

    }
}
