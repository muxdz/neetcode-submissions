class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numDict = dict()

        for i in range(len(nums)):
            num = nums[i]
            numDict[num] = i

        for i in range(len(nums)):
            need = target - nums[i]
            if (numDict.get(need) is None):
                continue
            else:
                if (i == numDict[need]):
                    continue
                return [i, numDict[need]]

