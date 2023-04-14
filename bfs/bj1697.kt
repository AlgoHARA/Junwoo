import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* 1697 숨박꼭질
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s, e) = readLine().split(" ").map { it.toInt() }
    val time = IntArray(100001) { 0 }
    val queue = LinkedList<Int>()
    val visited = BooleanArray(100001)

    fun bfs(start: Int): Int {
        queue.add(start)
        visited[start] = true
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            if (temp == e) {
                return time[e]
            }
            if (temp - 1 >= 0 && !visited[temp - 1]) {
                queue.add(temp - 1)
                visited[temp - 1] = true
                time[temp - 1] = time[temp] + 1
            }
            if (temp + 1 <= 100000 && !visited[temp + 1]) {
                queue.add(temp + 1)
                visited[temp + 1] = true
                time[temp + 1] = time[temp] + 1
            }
            if (temp * 2 <= 100000 && !visited[temp * 2]) {
                queue.add(temp * 2)
                visited[temp * 2] = true
                time[temp * 2] = time[temp] + 1
            }
        }
        return -1
    }
    print(bfs(s))
}
