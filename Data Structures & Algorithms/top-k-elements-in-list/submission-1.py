class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = dict()

        for num in nums:
            count = freqMap.get(num)
            if count is None:
                freqMap[num] = 1
            else:
                freqMap[num] += 1

        sortedMap = {key: val for key, val in sorted(freqMap.items(), key=lambda item: item[1], reverse=True)}
        listKey = list(sortedMap.keys())
        return listKey[0:k]