import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
* 7576 토마토
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val box = Array(n) { IntArray(m) }
    var day = 0
    var unripe = 0
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, c ->
            box[it][index] = c
            when (c) {
                1 -> queue.add(Pair(it, index)) // 익은 토마토 = 출발점
                0 -> unripe++ // 안익은 토마토 
            }
        }
    }

    fun bfs() {
        while (queue.isNotEmpty()) {
            day++ // 한번 퍼뜨리는 시점을 여기서 구해줌
            val size = queue.size
            repeat(size) { // 처음 익은 토마토의 개수 만큼 bfs
                val head = queue.poll()
                val dx = head.first
                val dy = head.second
                if (dx + 1 < n) {
                    if (box[dx + 1][dy] == 0) {
                        box[dx + 1][dy] = 1
                        unripe--
                        queue.offer(Pair(dx + 1, dy))
                    }
                }
                if (dx - 1 >= 0) {
                    if (box[dx - 1][dy] == 0) {
                        box[dx - 1][dy] = 1
                        unripe--
                        queue.offer(Pair(dx - 1, dy))
                    }
                }
                if (dy + 1 < m) {
                    if (box[dx][dy + 1] == 0) {
                        box[dx][dy + 1] = 1
                        unripe--
                        queue.offer(Pair(dx, dy + 1))
                    }

                }
                if (dy - 1 >= 0) {
                    if (box[dx][dy - 1] == 0) {
                        box[dx][dy - 1] = 1
                        unripe--
                        queue.offer(Pair(dx, dy - 1))
                    }
                }
            }
        }
    }

    if (unripe == 0) {
        print(0)
    } else {
        bfs()
        if(unripe > 0) print(-1)
        else print(day-1)
    }
}
