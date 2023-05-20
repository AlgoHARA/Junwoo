import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj17144 미세먼지 안녕!
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val (r, c, t) = readLine().split(" ").map { it.toInt() }
    val air = mutableListOf<Pair<Int, Int>>()
    val map = Array(r) { IntArray(c) }

    repeat(r) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { col, i ->
            map[row][col] = i
            if (i == -1) {
                air.add(Pair(row, col))
            }
        }
    }

    repeat(t) {

        // 미세먼지 확산
        val tempMap = Array(r) { IntArray(c) }
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] > 0) {
                    val spread = map[i][j] / 5
                    var cnt = 0
                    for (k in 0 until 4) {
                        val nx = i + dx[k]
                        val ny = j + dy[k]
                        if (nx in 0 until r && ny in 0 until c && map[nx][ny] != -1) {
                            tempMap[nx][ny] += spread
                            cnt++
                        }
                    }
                    map[i][j] -= spread * cnt
                }
            }
        }
        for (i in tempMap.indices) {
            for (j in tempMap[i].indices) {
                map[i][j] += tempMap[i][j]
            }
        }

        // 공기청정기
        val upX = air[0].first
        val downX = air[1].first

        for (i in upX - 1 downTo 1) {
            map[i][0] = map[i - 1][0]
        }
        for (i in 0 until c - 1) {
            map[0][i] = map[0][i + 1]
        }
        for (i in 0 until upX) {
            map[i][c - 1] = map[i + 1][c - 1]
        }
        for (i in c - 1 downTo 1) {
            map[upX][i] = map[upX][i - 1]
        }
        map[upX][1] = 0

        for (i in downX + 1 until r - 1) {
            map[i][0] = map[i + 1][0]
        }
        for (i in 0 until c - 1) {
            map[r - 1][i] = map[r - 1][i + 1]
        }
        for (i in r - 1 downTo downX + 1) {
            map[i][c - 1] = map[i - 1][c - 1]
        }
        for (i in c - 1 downTo 1) {
            map[downX][i] = map[downX][i - 1]
        }
        map[downX][1] = 0
    }

    var result = 0
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] > 0) {
                result += map[i][j]
            }
        }
    }
    println(result)
}
