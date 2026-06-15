/**
 * Problem: Coin Change (Minimum Coins)
 * Find the minimum number of coins needed to make up the target amount.
 * You may use each coin denomination unlimited times.
 *
 * Recurrence Relation:
 *   dp[0] = 0
 *   dp[amount] = min(dp[amount - coin] + 1) for each coin <= amount
 *
 * Time Complexity: O(amount * n) where n = number of coins
 * Space Complexity: O(amount)
 */

fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 } // Initialize with impossible value
    dp[0] = 0

    for (a in 1..amount) {
        for (coin in coins) {
            if (coin <= a) {
                dp[a] = minOf(dp[a], dp[a - coin] + 1)
            }
        }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
}

fun main() {
    // Test Case 1: Classic coin change
    val coins1 = intArrayOf(1, 5, 6, 9)
    val amount1 = 11
    println("Test 1: coins = ${coins1.contentToString()}, amount = $amount1")
    println("Min Coins: ${coinChange(coins1, amount1)}")
    println("Expected: 2  (5 + 6)\n")

    // Test Case 2: No solution
    val coins2 = intArrayOf(2)
    val amount2 = 3
    println("Test 2: coins = ${coins2.contentToString()}, amount = $amount2")
    println("Min Coins: ${coinChange(coins2, amount2)}")
    println("Expected: -1 (cannot make 3 with only 2s)\n")

    // Test Case 3: Standard denominations
    val coins3 = intArrayOf(1, 2, 5)
    val amount3 = 11
    println("Test 3: coins = ${coins3.contentToString()}, amount = $amount3")
    println("Min Coins: ${coinChange(coins3, amount3)}")
    println("Expected: 3  (5 + 5 + 1)")
}
