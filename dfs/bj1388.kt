import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
1388 바닥장식
*/

private var N = 0;
private var M = 0
private lateinit var arr: Array<CharArray>
private lateinit var visit: Array<BooleanArray>
private val dirX = arrayOf(0, 0, -1, 1)
private val dirY = arrayOf(-1, 1, 0, 0)

private var nowX = 0;
private var nowY = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val input = readLine().split(" ").map { it.toInt() }
    N = input[0]
    M = input[1]

    arr = Array(N) { CharArray(M) }
    visit = Array(N) { BooleanArray(M) }
    for (i in 0 until N) {
        val temp = readLine()
        for (j in 0 until M) {
            arr[i][j] = temp[j]
        }
    }

    var result = 0
    // 가로 탐색
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (!visit[i][j] && arr[i][j] == '-') {
                DFS(i, j, 0, 2, '-')
                result++
            }
        }
    }

    // 세로 탐색
    for (i in 0 until M) {
        for (j in 0 until N) {
            if (!visit[j][i] && arr[j][i] == '|') {
                DFS(j, i, 2, 4, '|')
                result++
            }
        }
    }

    print(result)
} // End of main

private fun DFS(x: Int, y: Int, idxStart: Int, idxEnd: Int, ch: Char) {
    visit[x][y] = true

    for (i in idxStart until idxEnd) {
        nowX = dirX[i] + x
        nowY = dirY[i] + y

        if (range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == ch) {
            DFS(nowX, nowY, idxStart, idxEnd, ch)
        }
    }
} // End of DFS

private fun range_check(): Boolean {
    return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M
} // End of range_check
