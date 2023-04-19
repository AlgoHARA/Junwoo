import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StrictMath.min
import java.util.LinkedList

/*
* 1389 케빈 베이컨의 6단계 법칙
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }
    val visited = BooleanArray(n + 1)
    var result = Int.MAX_VALUE
    var num = 0

    val queue = LinkedList<Int>()

    repeat(m) {
        val (n, e) = readLine().split(" ").map { it.toInt() }
        graph[n].add(e)
        graph[e].add(n)
    }

    fun bfs(start: Int): Int {
        var level = 1
        var kevin = 0
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {

            repeat(queue.size) { _ ->
                val head = queue.poll()
                graph[head].forEach {
                    if (!visited[it]) {
                        visited[it] = true
                        queue.add(it)
                        kevin += level
                    }
                }
            }
            level++
        }
        return kevin
    }

    repeat(n) {
        val temp = bfs(it + 1)
        if (result > temp) {
            result = temp
            num = it + 1
        }
        visited.fill(false)
    }
    println(num)
}
