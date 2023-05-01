import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* 2178 미로탐색
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val queue = LinkedList<Pair<Int, Int>>()

    val map = Array(n) { IntArray(m) }
    val visited = Array(n) { IntArray(m) }

    repeat(n) { col ->
        readLine().map { it.toInt() - 48 }.forEachIndexed { row, i ->
            map[col][row] = i
        }
    }

    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val head = queue.poll()
        for (i in 0 until 4) {
            val dx = head.first + dx[i]
            val dy = head.second + dy[i]
            if (dx in 0 until n && dy in 0 until m && visited[dx][dy] == 0 && map[dx][dy] == 1) {
                queue.offer(Pair(dx, dy))
                visited[dx][dy] = visited[head.first][head.second] + 1
            }
        }
    }
    print(visited[n - 1][m - 1] + 1)
}
