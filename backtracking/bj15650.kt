import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 15650 N과 M(2)
*/ 

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1)
    fun dfs(nums: String, start: Int, depth: Int) {
        if (depth == m) {
            println(nums.trim())
            return
        }
        for (i in start..n) {
            if (!visited[i]) {
                visited[i] = true
                dfs("$nums$i ", i,depth + 1)
                visited[i] =false
            }
        }
    }
    dfs("", 1,0)
}
