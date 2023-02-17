import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

/*
11725 트리의 부모 찾기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt() // 노드
    val tree = Array<ArrayList<Int>>(n + 1) { ArrayList() } // 그래프를 이중배열의 형식으로 구현
    val visited = BooleanArray(n + 1)
    val bw = BufferedWriter(OutputStreamWriter(System.out)) // 빠른 입출력을 위한 BufferedWriter
    val queue = LinkedList<Int>() // 선입선출을 위한 LinkedList
    val parent = IntArray(n + 1) { 0 }


    repeat(n - 1) { // 연결된 엣지 만큼 그래프에 해당 노드에 에 어디어디가 연결되었는지 리스트 형태에 더해줌
        val (node, near) = readLine().split(" ").map { it.toInt() }
        tree[node].add(near)
        tree[near].add(node)
    }

    fun bfs(start: Int) {
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val head = queue.poll() // 첫 원소 반환 후 remove
            tree[head].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    parent[it] = head // 해당 상태에 진입했을때는 head는 부모이므로 각 it 자리에 head를 넣어줌
                    queue.add(it)
                }
            }
        }
    }
    bfs(1)
    repeat(n-1){
        bw.append("${parent[it+2]}\n")    }
    bw.flush()
    bw.close()
}
