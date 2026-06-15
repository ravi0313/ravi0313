/**
 * Problem: Number of Islands
 * Given a 2D grid of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and formed by connecting adjacent land cells horizontally/vertically.
 *
 * Approach: For each unvisited '1', run DFS to mark the entire island as visited.
 * Count how many times DFS is triggered.
 *
 * Time Complexity: O(m * n) where m = rows, n = cols
 * Space Complexity: O(m * n) worst case recursion stack
 */

fun numIslands(grid: Array<CharArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') return
        grid[r][c] = '0' // Mark as visited
        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++
                dfs(r, c)
            }
        }
    }

    return count
}

fun main() {
    // Test Case 1: 3 islands
    val grid1 = arrayOf(
        charArrayOf('1','1','0','0','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','1','0','0'),
        charArrayOf('0','0','0','1','1')
    )
    println("Test 1:")
    grid1.forEach { println("  ${it.concatToString()}") }
    println("Number of Islands: ${numIslands(grid1)}")
    println("Expected: 3\n")

    // Test Case 2: All land
    val grid2 = arrayOf(
        charArrayOf('1','1','1'),
        charArrayOf('1','1','1'),
        charArrayOf('1','1','1')
    )
    println("Test 2: All land")
    grid2.forEach { println("  ${it.concatToString()}") }
    println("Number of Islands: ${numIslands(grid2)}")
    println("Expected: 1\n")

    // Test Case 3: No islands
    val grid3 = arrayOf(
        charArrayOf('0','0','0'),
        charArrayOf('0','0','0')
    )
    println("Test 3: All water")
    grid3.forEach { println("  ${it.concatToString()}") }
    println("Number of Islands: ${numIslands(grid3)}")
    println("Expected: 0")
}
