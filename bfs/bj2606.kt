import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

/*
2606 바이러스
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt() // 노드
    val m = readLine().toInt() // 엣지
    val graph = Array<ArrayList<Int>>(n + 1) { ArrayList() } // 그래프를 이중배열의 형식으로 구현
    val visited = BooleanArray(n + 1) { false } // 방문한 컴퓨터를 리스트로 표현
    val queue = LinkedList<Int>() // 선입선출을 위한 LinkedList


    repeat(m) { // 연결된 엣지 만큼 그래프에 해당 노드에 에 어디어디가 연결되었는지 리스트 형태에 더해줌
        val (node, near) = readLine().split(" ").map { it.toInt() }
        graph[node].add(near)
        graph[near].add(node)
    }

    fun bfs(start: Int) {
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val head = queue.poll() // 첫 원소 반환 후 remove
            graph[head].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    queue.add(it)
                }
            }
        }
    }
    bfs(1)
    print(visited.count() { it } - 1)

}
