class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, List<Integer>> pointer = new HashMap<>();

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
        }

        for (Integer num: frequency.keySet()) {
            int numFrequency = frequency.get(num);
            List<Integer> list = pointer.get(numFrequency);
            if (list == null) {
                list = new ArrayList<>();
                pointer.put(numFrequency, list);
            }
            list.add(num);
        }

        int[] topK = new int[k];

        int size = 0;
        int index = nums.length;
        while (size < k) {
            List<Integer> list = pointer.get(index);

            if (list != null) {
                for (Integer num : list) {
                    topK[size] = num;
                    size++;

                    if (size == k) {
                        break;
                    }
                }
            }
            
            index--;
        }

        return topK;
    }
}
