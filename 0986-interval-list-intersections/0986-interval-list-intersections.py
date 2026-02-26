class Solution:
    def intervalIntersection(self, firstList, secondList):
        ans = []
        i, j = 0, 0

        while i < len(firstList) and j < len(secondList):
            st = max(firstList[i][0], secondList[j][0])
            et = min(firstList[i][1], secondList[j][1])

            if st <= et:
                ans.append([st, et])

            if firstList[i][1] <= secondList[j][1]:
                i += 1
            else:
                j += 1

        return ans