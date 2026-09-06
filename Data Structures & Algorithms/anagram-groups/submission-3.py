class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        maps = dict()

        for word in strs:
            freqMap = [0 for i in range(26)]
            for c in word:
                freqMap[ord(c) - ord('a')] += 1
            
            check = tuple(freqMap)
            foundMatch = maps.get(check)
            if foundMatch is None:
                maps[check] = [word]
            else:
                maps[check].append(word)

        return list(maps.values())