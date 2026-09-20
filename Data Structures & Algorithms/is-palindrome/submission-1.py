import re

class Solution:
    def isPalindrome(self, s: str) -> bool:
        blank = re.sub(r"[^0-9A-Za-z]", "", s).lower()
        return blank == blank[::-1]

        