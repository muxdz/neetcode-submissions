class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSet = [set() for i in range(len(board))]
        columnSet = [set() for i in range(len(board))]
        squareSet = [set() for i in range(len(board))]

        for i in range(len(board)):
            row = board[i]

            for j in range(len(row)):
                char = row[j]
                if char == '.':
                    continue
                else:
                    curRowSet = rowSet[i]
                    curColumnSet = columnSet[j]
                    curSquareSet = squareSet[int(i/3)*3 + int(j/3)]

                    if char in curRowSet or char in curColumnSet or char in curSquareSet:
                        return False
                    else:
                        curRowSet.add(char)
                        curColumnSet.add(char)
                        curSquareSet.add(char)

        return True
                        
        