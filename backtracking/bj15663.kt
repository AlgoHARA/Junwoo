import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 15663 N과 M(9)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(n)
    val result = mutableSetOf<String>()
    fun backtrack(nums: String, depth: Int) {
        if (depth == m) {
            result.add(nums.trim())
            return
        }
        for (i in 0..n - 1) {
            if (!visited[i]){
                visited[i] = true
                backtrack("$nums${list[i]} ",depth + 1)
                visited[i] = false
            }
        }
    }
    backtrack("", 0)
    print(result.joinToString("\n"))
}
