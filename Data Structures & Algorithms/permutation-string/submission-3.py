class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False

        s1Char = [0 for i in range(26)]
        window = [0 for i in range(26)]

        for i in range(len(s1)):
            s1Char[ord(s1[i]) - ord('a')] += 1
            window[ord(s2[i]) - ord('a')] += 1

        left = 0
        right = len(s1) - 1

        while (right < len(s2)):
            if (s1Char == window):
                return True

            right += 1
            if right == len(s2):
                break

            window[ord(s2[right]) - ord('a')] += 1
            window[ord(s2[left]) - ord('a')] -= 1
            left += 1

        return False

