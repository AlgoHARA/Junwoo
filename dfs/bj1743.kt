import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1743 음식물 피하기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var result = -1
    var temp = 0

        val (n, m, k) = readLine().split(" ").map { it.toInt() }
        val graph = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) }
        repeat(k) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            graph[x-1][y-1] = 1
        }

        fun dfs(x: Int, y: Int) {
            visited[x][y] = true
            temp++
            if (x - 1 >= 0) {
                if (graph[x - 1][y] == 1 && !(visited[x - 1][y])) dfs(x - 1, y)
            }
            if (x + 1 < n) {
                if (graph[x + 1][y] == 1 && !(visited[x + 1][y])) dfs(x + 1, y)
            }
            if (y - 1 >= 0) {
                if (graph[x][y - 1] == 1 && !(visited[x][y - 1])) dfs(x, y - 1)
            }
            if (y + 1 < m) {
                if (graph[x][y + 1] == 1 && !(visited[x][y + 1])) dfs(x, y + 1)
            }
        }
        graph.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, i ->
                if (graph[x][y] == 1) {
                    if (!visited[x][y]) {
                        temp = 0
                        dfs(x, y)
                        result = kotlin.math.max(result,temp)
                    }
                }
            }
        }

    print(result)
}
