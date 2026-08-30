class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sDict = dict()
        tDict = dict()

        for i in range(len(s)):
            char = s[i]
            count = sDict.get(char, 0)
            sDict[char] = count+1
        
        for i in range(len(t)):
            char = t[i]
            count = tDict.get(char, 0)
            tDict[char] = count+1

        return (sDict == tDict)
        