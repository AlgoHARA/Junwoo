import java.io.BufferedReader
import java.io.InputStreamReader

/*
2606 바이러스
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val m = readLine().toInt()
    val graph = Array<ArrayList<Int>>(n+1) { ArrayList() }
    val visited = BooleanArray(m+1) { false }

    repeat(m) {
        val (node, near) = readLine().split(" ").map { it.toInt() }
        graph[node].add(near)
        graph[near].add(node)
    }

    fun dfs(index: Int) {
        visited[index] = true
        graph[index].forEach{
            if (!visited[it]) {
                dfs(it)
            }
        }
    }
    if(n == 1 || m == 0)
        print(0)
    else{
        dfs(1)
        print(visited.count { it } - 1)
    }
}
