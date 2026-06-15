/**
 * Problem: Sudoku Solver
 * Solve a 9×9 Sudoku board by filling empty cells ('.') with digits 1-9.
 * Each digit must appear exactly once in each row, column, and 3×3 sub-box.
 *
 * Backtracking Approach:
 *   - Find next empty cell.
 *   - Try digits 1–9. If valid, place and recurse.
 *   - If recursion fails, reset cell (backtrack) and try next digit.
 *
 * Recursion Tree: At each empty cell, up to 9 branches — heavily pruned by constraints.
 *
 * Time Complexity: O(9^m) where m = number of empty cells
 * Space Complexity: O(m) recursion stack
 */

fun solveSudoku(board: Array<CharArray>): Boolean {
    for (row in 0..8) {
        for (col in 0..8) {
            if (board[row][col] == '.') {
                for (ch in '1'..'9') {
                    if (isValidSudoku(board, row, col, ch)) {
                        board[row][col] = ch
                        if (solveSudoku(board)) return true
                        board[row][col] = '.' // Backtrack
                    }
                }
                return false // No digit worked
            }
        }
    }
    return true // All cells filled
}

fun isValidSudoku(board: Array<CharArray>, row: Int, col: Int, ch: Char): Boolean {
    for (i in 0..8) {
        if (board[row][i] == ch) return false // Row check
        if (board[i][col] == ch) return false // Col check
        // Box check
        val boxRow = 3 * (row / 3) + i / 3
        val boxCol = 3 * (col / 3) + i % 3
        if (board[boxRow][boxCol] == ch) return false
    }
    return true
}

fun printBoard(board: Array<CharArray>) {
    for ((i, row) in board.withIndex()) {
        if (i % 3 == 0 && i != 0) println("------+-------+------")
        val line = row.toList().withIndex().joinToString(" ") { (j, c) ->
            if (j % 3 == 0 && j != 0) "| $c" else "$c"
        }
        println(line)
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9')
    )

    println("Input Sudoku Board:")
    printBoard(board)

    val solved = solveSudoku(board)
    println("\nSolved: $solved")
    println("\nSolution:")
    printBoard(board)
    println("\nExpected: Valid Sudoku solution (unique for this input)")
}
