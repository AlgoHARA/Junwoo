import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 14503 로봇청소기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(-1, 0, 1, 0)
    var result = 0
    
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    var (r, c, d) = readLine().split(" ").map { it.toInt() } // 0북 1동 2남 3서

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    while (true) {
        if (map[r][c] == 0) {
            map[r][c] = 2
            result++
        }
        var flag = true
        repeat(4) {
            val y = r + dy[it]
            val x = c + dx[it]
            if (x in 0 .. m && y in 0 .. n) {
                if (map[y][x] == 0) flag = false
            }
        }
        //println("$count $able")
        if (flag) {
            val y = r - dy[d]
            val x = c - dx[d]
            if (x in 0 ..m && y in 0 .. n) {
                if (map[y][x] == 1) break
                else {
                    r = y
                    c = x
                }
            }
        } else {
            d -= 1
            if (d == -1) d = 3
            val y = r + dy[d]
            val x = c + dx[d]
            if (x in 0 .. m && y in 0 .. n) {
                if (map[y][x] == 0) {
                    r = y
                    c = x
                }
            }
        }
    }
    println(result)
}
