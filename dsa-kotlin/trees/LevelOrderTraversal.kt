/**
 * Problem: Level Order Traversal (BFS)
 * Traverse a binary tree level by level using breadth-first search.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.LinkedList
import java.util.Queue

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result
    
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()
        
        for (i in 0 until levelSize) {
            val node = queue.poll()
            currentLevel.add(node.value)
            
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        
        result.add(currentLevel)
    }
    
    return result
}

fun main() {
    // Build test tree:
    //       3
    //      / \
    //     9  20
    //       /  \
    //      15   7
    
    val root = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    
    println("Test 1: Balanced Tree")
    println("Tree structure:")
    println("       3")
    println("      / \\")
    println("     9  20")
    println("       /  \\")
    println("      15   7")
    
    val result1 = levelOrderTraversal(root)
    println("\nLevel Order Traversal:")
    result1.forEachIndexed { index, level ->
        println("Level $index: $level")
    }
    println("Expected: [3], [9, 20], [15, 7]\n")
    
    // Test Case 2: Single node
    val root2 = TreeNode(42)
    println("Test 2: Single Node")
    val result2 = levelOrderTraversal(root2)
    println("Result: $result2")
    println("Expected: [[42]]\n")
    
    // Test Case 3: Empty tree
    println("Test 3: Empty Tree")
    val result3 = levelOrderTraversal(null)
    println("Result: $result3")
    println("Expected: []")
}
