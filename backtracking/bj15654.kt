import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
* 15654 N과 M(5)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(n)
    val sb = StringBuilder()
    fun backtrack(nums: String, depth: Int) {
        if (depth == m) {
            sb.append("${nums.trim()}\n")
            return
        }
        for (i in 0..n - 1) {
                backtrack("$nums${list[i]} ", depth + 1)
        }
    }
    backtrack("", 0)
    print(sb)
}
