import java.io.BufferedReader
import java.io.InputStreamReader

/*
2667 단지번호 붙이기_dfs
 */


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    val result = mutableListOf<Int>()
    var count = 0
    var total = 0
    val n = readLine().toInt()

    val map = Array(n) { IntArray(n) }
    val visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        readLine().map { it.toInt() - 48 }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    fun dfs(x: Int, y: Int): Int {
        visited[x][y] = true
        for (i in 0 until 4) {
            val dx = x + dx[i]
            val dy = y + dy[i]
            if (dx in 0 until n && dy in 0 until n && map[dx][dy] == 1 && !visited[dx][dy]) {
                dfs(dx, dy)
                count++
            }
        }
        return count + 1
    }

    map.forEachIndexed { col, it ->
        it.forEachIndexed { row, i ->
            if (map[col][row] == 1 && !visited[col][row]) {
                count = 0
                result.add(dfs(col, row))
                total++
            }
        }
    }
    println(total)
    println(result.sorted().joinToString("\n"))
}
