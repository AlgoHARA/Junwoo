import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
* 15652 N과 M(4)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    fun backtrack(nums: String, start:Int, depth: Int) {
        if (depth == m) {
            sb.append("${nums.trim()}\n")
            return
        }
        for (i in start..n) {
            backtrack("$nums$i ",i,depth + 1)
        }
    }
    backtrack("", 1,0)
    print(sb)
}
