import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

/*
* 2407 조합
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    fun combination(n: Int, m: Int): BigInteger {
        val dp = Array(n + 1) { BigInteger.ZERO }
        dp[0] = BigInteger.ONE

        for (i in 1..n) {
            for (j in minOf(i, m) downTo 1) {
                dp[j] = dp[j].add(dp[j - 1])
            }
        }

        return dp[m]
    }
    println(combination(n, m))
}
