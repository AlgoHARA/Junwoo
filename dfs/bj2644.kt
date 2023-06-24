import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj2644 촌수계산
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val (x, y) = readLine().split(" ").map { it.toInt() }
    val t = readLine().toInt()
    val graph = Array(n + 1) { arrayListOf<Int>() }
    val visited = BooleanArray(n + 1)
    var result = -1

    repeat(t) {
        val (n, e) = readLine().split(" ").map { it.toInt() }
        graph[n].add(e)
        graph[e].add(n)
    }

    fun dfs(num: Int, depth: Int) {

        if (num == y) {
            result = depth
            return
        }
        if (depth == n - 1) return

        graph[num].forEach {
            if (!visited[it]) {
                visited[it] = true
                dfs(it, depth + 1)
            }
        }
    }
    dfs(x, 0)
    print(result)
}
