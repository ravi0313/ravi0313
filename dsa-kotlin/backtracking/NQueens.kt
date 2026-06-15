/**
 * Problem: N-Queens
 * Place N queens on an N×N chessboard such that no two queens attack each other.
 * Queens attack on the same row, column, or diagonal.
 *
 * Backtracking Approach:
 *   - Try placing a queen in each column of the current row.
 *   - Check if placement is safe (no conflict with existing queens).
 *   - Recurse to next row. If no safe spot, backtrack and try next column.
 *
 * Recursion Tree: At each row, branch into N options, pruned by safety check.
 *
 * Time Complexity: O(N!) — highly pruned in practice
 * Space Complexity: O(N²) for board + O(N) recursion stack
 */

fun solveNQueens(n: Int): List<List<String>> {
    val results = mutableListOf<List<String>>()
    val board = Array(n) { CharArray(n) { '.' } }

    fun isSafe(row: Int, col: Int): Boolean {
        // Check column above
        for (r in 0 until row) if (board[r][col] == 'Q') return false
        // Check upper-left diagonal
        var r = row - 1; var c = col - 1
        while (r >= 0 && c >= 0) { if (board[r--][c--] == 'Q') return false }
        // Check upper-right diagonal
        r = row - 1; c = col + 1
        while (r >= 0 && c < n) { if (board[r--][c++] == 'Q') return false }
        return true
    }

    fun backtrack(row: Int) {
        if (row == n) {
            results.add(board.map { it.concatToString() })
            return
        }
        for (col in 0 until n) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q'
                backtrack(row + 1)
                board[row][col] = '.' // Backtrack
            }
        }
    }

    backtrack(0)
    return results
}

fun main() {
    // Test Case 1: 4-Queens
    println("Test 1: 4-Queens")
    val solutions4 = solveNQueens(4)
    println("Number of solutions: ${solutions4.size}")
    println("Expected: 2")
    solutions4.forEachIndexed { i, sol ->
        println("Solution ${i + 1}:")
        sol.forEach { println("  $it") }
    }
    println()

    // Test Case 2: 1-Queen
    println("Test 2: 1-Queen")
    val solutions1 = solveNQueens(1)
    println("Number of solutions: ${solutions1.size}")
    println("Expected: 1")
    solutions1.forEach { sol -> sol.forEach { println("  $it") } }
    println()

    // Test Case 3: 8-Queens (count only)
    println("Test 3: 8-Queens (count only)")
    val solutions8 = solveNQueens(8)
    println("Number of solutions: ${solutions8.size}")
    println("Expected: 92")
}
