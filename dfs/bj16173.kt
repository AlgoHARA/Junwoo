import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 16173 점프왕쩰리
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val graph = Array(n) { IntArray(n) }
    val visited = Array(n) { BooleanArray(n) }
    repeat(n) { x ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { y, jump ->
            graph[x][y] = jump
        }
    }

    fun dfs(x: Int, y: Int) {
        visited[x][y] = true
        val jump = graph[x][y]
        if (graph[x][y] == -1 || graph[x][y] == 0) return
        if (y + jump <= n - 1) dfs(x, y + jump)
        if (x + jump <= n - 1) dfs(x + jump, y)
    }

    dfs(0, 0)

    if (visited[n - 1][n - 1])
        print("HaruHaru")
    else
        print("Hing")
}
