class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char task: tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(frequency.get(b), frequency.get(a)));

        for (char task: frequency.keySet()) {
            maxHeap.add(task);
        }

        int time = 0;
        HashMap<Character, Integer> nextAvailable = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            if (maxHeap.isEmpty()) {
                time = nextAvailable.get(queue.peek());
            }

            while (!queue.isEmpty() && nextAvailable.get(queue.peek()) <= time) {
                maxHeap.add(queue.poll());
            }

            char mostFreq = maxHeap.poll();
            int freq = frequency.get(mostFreq);

            time++;

            frequency.put(mostFreq, freq-1);

            if (freq > 1) {
                nextAvailable.put(mostFreq, time+n);
                queue.add(mostFreq);
            }
        }

        return time;
    }
}
