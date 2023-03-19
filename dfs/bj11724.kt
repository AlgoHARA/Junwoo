import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 연결 요소의 개수
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var count = 0
    var dot = 1
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1) { false }
    visited[0] = true
    repeat(m) {
        val (node, edge) = readLine().split(" ").map { it.toInt() }
        graph[node].add(edge)
        graph[edge].add(node)
    }

    fun dfs(n: Int) {
        visited[n] = true
        graph[n].forEach {
            if (!visited[it]) dfs(it)
        }
    }

    while (true) {
        if (visited.all { it }) break
        if(!visited[dot]){
            count++
            dfs(dot)
        }
        dot++
    }
    print(count)
}
