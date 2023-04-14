import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
/*
* N과 M(3)
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    fun backtrack(nums: String, depth: Int) {
        if (depth == m) {
            sb.append("${nums.trim()}\n")
            return
        }
        for (i in 1..n) {
            backtrack("$nums$i ",depth + 1)
        }
    }
    backtrack("", 0)
    print(sb)
}
