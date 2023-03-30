import java.io.BufferedReader
import java.io.InputStreamReader

/*
2630 색종이 만들기
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val paper = Array(n) { IntArray(n) }
    var blue = 0
    var white = 0
    for (i in 0 until n) {
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until n) {
            paper[i][j] = row[j]
        }
    }

    fun divideAndConquer(row: Int, col: Int, size: Int) { // 시작점 과 탐색할 size
        if (size == 1) {
            if (paper[row][col] == 1)
                blue++
            else
                white++
            return
        }
        var whiteCount = 0
        var blueCount = 0
        for (i in row until row + size) { // size 만큼 내부의 
						//파란색 하얀색 색종이를 검사한다.
            for (j in col until col + size) {
                if (paper[i][j] == 1) {
                    blueCount++
                } else {
                    whiteCount++
                }
            }
        }
        if (blueCount == 0) {
            white++
            return
        }
        if (whiteCount == 0) {
            blue++
            return
        }
        val halfSize = size / 2
        divideAndConquer(row, col, halfSize)
        divideAndConquer(row, col + halfSize, halfSize)
        divideAndConquer(row + halfSize, col, halfSize)
        divideAndConquer(row + halfSize, col + halfSize, halfSize)
    }

    divideAndConquer(0, 0, n)
    println("$white\n$blue")
}
