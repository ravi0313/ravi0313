/**
 * Problem: Serialize and Deserialize Binary Tree
 * Convert a binary tree to a string (serialize) and reconstruct it (deserialize).
 *
 * Approach: Use preorder traversal. Serialize null nodes as "null".
 * Deserialize by consuming tokens left-to-right recursively.
 *
 * Time Complexity: O(n) for both serialize and deserialize
 * Space Complexity: O(n)
 */

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

const val NULL_MARKER = "null"
const val SEPARATOR = ","

fun serialize(root: TreeNode?): String {
    val sb = StringBuilder()

    fun dfs(node: TreeNode?) {
        if (node == null) {
            sb.append("$NULL_MARKER$SEPARATOR")
            return
        }
        sb.append("${node.value}$SEPARATOR")
        dfs(node.left)
        dfs(node.right)
    }

    dfs(root)
    return sb.toString().trimEnd(',')
}

fun deserialize(data: String): TreeNode? {
    val tokens = ArrayDeque(data.split(SEPARATOR))

    fun dfs(): TreeNode? {
        val token = tokens.removeFirst()
        if (token == NULL_MARKER) return null
        val node = TreeNode(token.toInt())
        node.left = dfs()
        node.right = dfs()
        return node
    }

    return dfs()
}

fun inorder(node: TreeNode?, result: MutableList<Int> = mutableListOf()): List<Int> {
    if (node != null) {
        inorder(node.left, result)
        result.add(node.value)
        inorder(node.right, result)
    }
    return result
}

fun main() {
    // Test Case 1: Complete tree
    //       1
    //      / \
    //     2   3
    //        / \
    //       4   5
    val root1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
    }
    println("Test 1: Original inorder: ${inorder(root1)}")
    val serialized1 = serialize(root1)
    println("Serialized: $serialized1")
    val deserialized1 = deserialize(serialized1)
    println("Deserialized inorder: ${inorder(deserialized1)}")
    println("Match: ${inorder(root1) == inorder(deserialized1)}\n")

    // Test Case 2: Single node
    val root2 = TreeNode(42)
    println("Test 2: Single node [42]")
    val serialized2 = serialize(root2)
    println("Serialized: $serialized2")
    val deserialized2 = deserialize(serialized2)
    println("Deserialized: ${deserialized2?.value}")
    println("Expected: 42\n")

    // Test Case 3: null tree
    println("Test 3: Null tree")
    val serialized3 = serialize(null)
    println("Serialized: $serialized3")
    val deserialized3 = deserialize(serialized3)
    println("Deserialized: $deserialized3")
    println("Expected: null")
}
