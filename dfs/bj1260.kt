import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
1260 DFS와 BFS
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m, start) = readLine().split(" ").map { it.toInt() }

    val graph = Array<ArrayList<Int>>(n + 1) { ArrayList() } // 그래프를 이중배열의 형식으로 구현
    val visited = BooleanArray(n + 1) // 방문
    val queue = LinkedList<Int>() // BFS 선입선출을 위한 LinkedList

    repeat(m) {
        val (node, edge) = readLine().split(" ").map { it.toInt() }
        graph[node].add(edge)
        graph[edge].add(node)
    }

    fun dfs(index: Int) {
        visited[index] = true
        bw.append("$index ")
        graph[index].sorted().forEach { // 노드가 여러개일때 작은 쪽 부터 방문해야하므로 정렬
            if (!visited[it]) {
                dfs(it)
            }
        }
    }

    fun bfs(start: Int) {
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) { // 노드가 여러개일때 작은 쪽 부터 방문해야하므로 정렬
            val head = queue.poll() // 첫 원소 반환 후 remove
            bw.append("$head ")
            graph[head].sorted().forEach {
                if (!visited[it]) {
                    visited[it] = true
                    queue.add(it)
                }
            }
        }
    }

    dfs(start)
    visited.fill(false)
    bw.append("\n")
    bfs(start)
    bw.flush()
    bw.close()
}
