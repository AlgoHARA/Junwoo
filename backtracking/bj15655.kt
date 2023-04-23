import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/*
* 15655 N과 M (6)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(n)
    val sb = StringBuilder()
    fun backtrack(nums: String, start: Int, depth: Int) {
        if (depth == m) {
            sb.append("${nums.trim()}\n")
            return
        }
        for (i in start..n - 1) {
            if(!visited[i]){
                visited[i] = true
                backtrack("$nums${list[i]} ", i, depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack("", 0,0)
    print(sb)
}
