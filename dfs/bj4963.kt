import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

/*
* 4963 섬의 개수
*/

var visited: Array<BooleanArray> = arrayOf()
var map: Array<IntArray> = arrayOf()
var n = 0
var m = 0
val dx = listOf(1, 0, -1, 0, 1, -1, 1, -1)
val dy = listOf(0, 1, 0, -1, 1, -1, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    var count = 0


    while (true) {
        val input = readLine().split(" ").map { it.toInt() }
        n = input[0]
        m = input[1]
        if (n == 0 && m == 0) {
            break
        }

        count = 0

        map = Array(m) { IntArray(n) }
        visited = Array(m) { BooleanArray(n) }
        repeat(m) {
            readLine().split(" ").map { it.toInt() }.forEachIndexed { index, num ->
                map[it][index] = num
            }
        }

        map.forEachIndexed { row, ints ->
            ints.forEachIndexed { col, i ->
                if (i == 1 && !visited[row][col]) {
                    dfs(row, col)
                    count++
                }
            }
        }

        sb.append("$count\n")
    }
    print(sb)

}

fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    for (i in 0 until 8) {
        val x = x + dx[i]
        val y = y + dy[i]
        if (x in 0 until m && y in 0 until n && !visited[x][y] && map[x][y] == 1) {
            dfs(x, y)
        }
    }
}
