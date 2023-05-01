import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* 2667 단지번호 붙이기_bfs
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val result = mutableListOf<Int>()
    var total = 0
    val n = readLine().toInt()

    val map = Array(n) { IntArray(n) }
    val visited = Array(n) { BooleanArray(n) }
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(n) {
        readLine().map { it.toInt() - 48 }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    fun bfs(x: Int, y: Int): Int {
        var count = 0
        queue.add(Pair(x, y))
        visited[x][y] = true
        while (queue.isNotEmpty()) {
            val head = queue.poll()
            for (i in 0 until 4) {
                val dx = head.first + dx[i]
                val dy = head.second + dy[i]
                if (dx in 0 until n && dy in 0 until n && map[dx][dy] == 1 && !visited[dx][dy]) {
                    visited[dx][dy] = true
                    queue.offer(Pair(dx, dy))
                    count++
                }
            }
        }
        return count + 1
    }


    map.forEachIndexed { col, it ->
        it.forEachIndexed { row, i ->
            if (map[col][row] == 1 && !visited[col][row]) {
                result.add(bfs(col, row))
                total++
            }
        }
    }
    println(total)
    println(result.sorted().joinToString("\n"))
}
