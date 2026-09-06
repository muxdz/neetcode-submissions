class Solution:

    def encode(self, strs: List[str]) -> str:
        out = ""
        for string in strs:
            out += str(len(string))
            out += '#'
            out += string
        return out

    def decode(self, s: str) -> List[str]:
        out = []
        strs = s.split('#')
        count = 0
        start = 0
        while (count < len(s)):
            if s[count] == '#':
                num = int(s[start:count])
                count += 1
                out.append(s[count:count+num])
                start = count+num
                count = count+num
            count += 1

        return out
