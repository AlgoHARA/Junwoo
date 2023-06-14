import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* bj12851 숨바꼭질 2
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s, e) = readLine().split(" ").map { it.toInt() }
    var min = Int.MAX_VALUE
    var count = 0
    val visited = BooleanArray(100001) { false }
    val queue = LinkedList<Pair<Int,Int>>()

    fun bfs(start: Int) {
        queue.add(Pair(start,0))
        visited[start] = true

        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            val now = temp.first
            val time = temp.second

            visited[now] = true
            if(min < time) break
            if(now == e){
                min = time
                count++
                continue
            }

            if (now - 1 >= 0 && !visited[now - 1]) {
                queue.add(Pair(now-1,time+1))
            }
            if (now + 1 <= 100000 && !visited[now + 1]) {
                queue.add(Pair(now+1,time+1))
            }
            if (now * 2 <= 100000 && !visited[now * 2]) {
                queue.add(Pair(now*2,time+1))
            }
        }

    }

    bfs(s)

    println(min)
    println(count)
}
