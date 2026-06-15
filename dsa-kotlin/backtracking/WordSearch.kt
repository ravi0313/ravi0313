/**
 * Problem: Word Search in 2D Grid
 * Given an m×n board of characters and a target word, return true if the word
 * exists in the grid. The word can be constructed from letters of sequentially
 * adjacent cells (horizontal or vertical). Each cell may not be used more than once.
 *
 * Backtracking Approach:
 *   - For each cell matching word[0], start DFS.
 *   - Mark cell as visited (temporarily), recurse in all 4 directions.
 *   - Backtrack by restoring the cell.
 *
 * Recursion Tree: 4 branches per step, depth = word.length → O(4^L) per starting cell.
 *
 * Time Complexity: O(m * n * 4^L) where L = word length
 * Space Complexity: O(L) recursion stack
 */

fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val cols = board[0].size
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    fun dfs(r: Int, c: Int, index: Int): Boolean {
        if (index == word.length) return true
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word[index]) return false

        val temp = board[r][c]
        board[r][c] = '#' // Mark visited

        val found = dirs.any { (dr, dc) -> dfs(r + dr, c + dc, index + 1) }

        board[r][c] = temp // Backtrack
        return found
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (dfs(r, c, 0)) return true
        }
    }
    return false
}

fun main() {
    // Test Case 1: Word exists
    val board1 = arrayOf(
        charArrayOf('A','B','C','E'),
        charArrayOf('S','F','C','S'),
        charArrayOf('A','D','E','E')
    )
    println("Test 1: board =")
    board1.forEach { println("  ${it.concatToString()}") }
    println("Search \"ABCCED\": ${exist(board1, "ABCCED")}")
    println("Expected: true\n")

    // Test Case 2: Word exists (same board)
    val board2 = arrayOf(
        charArrayOf('A','B','C','E'),
        charArrayOf('S','F','C','S'),
        charArrayOf('A','D','E','E')
    )
    println("Test 2: board =")
    board2.forEach { println("  ${it.concatToString()}") }
    println("Search \"SEE\": ${exist(board2, "SEE")}")
    println("Expected: true\n")

    // Test Case 3: Word doesn't exist
    val board3 = arrayOf(
        charArrayOf('A','B','C','E'),
        charArrayOf('S','F','C','S'),
        charArrayOf('A','D','E','E')
    )
    println("Test 3: board =")
    board3.forEach { println("  ${it.concatToString()}") }
    println("Search \"ABCB\": ${exist(board3, "ABCB")}")
    println("Expected: false (can't reuse cells)")
}
