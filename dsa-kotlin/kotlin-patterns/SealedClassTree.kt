/**
 * Sealed Class Binary Tree in Kotlin
 * Kotlin sealed classes model algebraic data types — a tree is either Empty or a Node.
 * Why cleaner than Java: No null checks, exhaustive `when` expressions replace
 * instanceof chains, functional recursion is natural and safe.
 *
 * Pattern matching with `when` replaces verbose if/instanceof chains from Java.
 */

// ─── Sealed Class Tree Definition ────────────────────────────────────────────

sealed class Tree<out T> {
    object Empty : Tree<Nothing>()
    data class Node<T>(val value: T, val left: Tree<T> = Empty, val right: Tree<T> = Empty) : Tree<T>()
}

// ─── Tree Operations using `when` pattern matching ────────────────────────────

fun <T> Tree<T>.inorder(): List<T> = when (this) {
    is Tree.Empty -> emptyList()
    is Tree.Node -> left.inorder() + listOf(value) + right.inorder()
}

fun <T> Tree<T>.preorder(): List<T> = when (this) {
    is Tree.Empty -> emptyList()
    is Tree.Node -> listOf(value) + left.preorder() + right.preorder()
}

fun <T> Tree<T>.height(): Int = when (this) {
    is Tree.Empty -> 0
    is Tree.Node -> 1 + maxOf(left.height(), right.height())
}

fun <T> Tree<T>.size(): Int = when (this) {
    is Tree.Empty -> 0
    is Tree.Node -> 1 + left.size() + right.size()
}

fun <T : Comparable<T>> Tree<T>.contains(target: T): Boolean = when (this) {
    is Tree.Empty -> false
    is Tree.Node -> when {
        target == value -> true
        target < value  -> left.contains(target)
        else            -> right.contains(target)
    }
}

// ─── Insert into BST ─────────────────────────────────────────────────────────

fun <T : Comparable<T>> Tree<T>.insert(item: T): Tree<T> = when (this) {
    is Tree.Empty -> Tree.Node(item)
    is Tree.Node -> when {
        item < value -> copy(left = left.insert(item))
        item > value -> copy(right = right.insert(item))
        else         -> this // Duplicate — no insert
    }
}

fun main() {
    // Build BST using sealed classes
    val tree = Tree.Empty
        .insert(5)
        .insert(3)
        .insert(7)
        .insert(1)
        .insert(4)
        .insert(6)
        .insert(8)

    println("=== Sealed Class Binary Search Tree ===\n")
    println("Tree built by inserting: [5, 3, 7, 1, 4, 6, 8]")
    println("Inorder  (sorted): ${tree.inorder()}")
    println("Expected:           [1, 3, 4, 5, 6, 7, 8]")
    println("Preorder:           ${tree.preorder()}")
    println("Height:             ${tree.height()}   Expected: 3")
    println("Size:               ${tree.size()}    Expected: 7")
    println()

    println("=== Contains (pattern matching) ===")
    println("contains(4): ${tree.contains(4)}   Expected: true")
    println("contains(9): ${tree.contains(9)}   Expected: false\n")

    println("=== Empty tree ===")
    println("Empty.inorder(): ${Tree.Empty.inorder()}")
    println("Empty.height(): ${Tree.Empty.height()}")
    println("Empty.size(): ${Tree.Empty.size()}")
}
