import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj2210 숫자판 점프
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val graph = Array(5) { IntArray(5) }
    val dx = listOf(0, 1, -1, 0)
    val dy = listOf(1, 0, 0, -1)
    val result = mutableSetOf<String>()
    repeat(5) { col ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { row, i ->
            graph[col][row] = i
        }
    }

    fun dfs(depth: Int, y: Int, x: Int, nums: String) {
        if (depth == 6) {
            result.add(nums)
            return
        }
        for (i in 0 until 4) {
            if (x + dx[i] in 0 until 5 && y + dy[i] in 0 until 5) {
                dfs(depth + 1, y + dy[i], x + dx[i], nums + graph[y][x])
            }
        }
    }

    repeat(5) { col ->
        repeat(5) { row ->
            dfs(0, col, row,"")
        }
    }
    print(result.size)
}
