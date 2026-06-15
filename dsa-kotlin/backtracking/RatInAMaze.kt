/**
 * Problem: Rat in a Maze
 * A rat starts at (0, 0) and must reach (N-1, N-1) in an N×N binary maze.
 * Cells with 1 are open, cells with 0 are blocked.
 * Find all paths from start to destination (moving Right or Down only).
 *
 * Backtracking Approach:
 *   - Try moving in each direction from current cell.
 *   - If move is valid (in bounds, open, not visited), recurse.
 *   - Backtrack by marking cell as unvisited when returning.
 *
 * Recursion Tree: 2 branches (right/down) per step, depth = 2*(N-1).
 *
 * Time Complexity: O(2^(N²)) worst case
 * Space Complexity: O(N²) for visited array
 */

fun findPaths(maze: Array<IntArray>): List<String> {
    val n = maze.size
    val results = mutableListOf<String>()
    val visited = Array(n) { BooleanArray(n) }
    val dirs = listOf('D' to (1 to 0), 'R' to (0 to 1), 'U' to (-1 to 0), 'L' to (0 to -1))

    fun backtrack(r: Int, c: Int, path: StringBuilder) {
        if (r == n - 1 && c == n - 1) {
            results.add(path.toString())
            return
        }
        for ((dir, delta) in dirs) {
            val (dr, dc) = delta
            val nr = r + dr
            val nc = c + dc
            if (nr in 0 until n && nc in 0 until n && maze[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true
                path.append(dir)
                backtrack(nr, nc, path)
                path.deleteCharAt(path.lastIndex) // Backtrack
                visited[nr][nc] = false
            }
        }
    }

    if (maze[0][0] == 1) {
        visited[0][0] = true
        backtrack(0, 0, StringBuilder())
    }

    return results
}

fun main() {
    // Test Case 1: Multiple paths
    val maze1 = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1)
    )
    println("Test 1: Maze =")
    maze1.forEach { println("  ${it.contentToString()}") }
    val paths1 = findPaths(maze1)
    println("Paths found: ${paths1.size}")
    paths1.forEach { println("  $it") }
    println("Expected: [DDRDRR, DRDDRR]\n")

    // Test Case 2: Single path
    val maze2 = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(0, 1)
    )
    println("Test 2: 2×2 Maze")
    maze2.forEach { println("  ${it.contentToString()}") }
    val paths2 = findPaths(maze2)
    println("Paths found: ${paths2.size}")
    paths2.forEach { println("  $it") }
    println("Expected: [RD]\n")

    // Test Case 3: No path
    val maze3 = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1)
    )
    println("Test 3: Blocked maze")
    maze3.forEach { println("  ${it.contentToString()}") }
    val paths3 = findPaths(maze3)
    println("Paths found: ${paths3.size}")
    println("Expected: 0 (no path)")
}
