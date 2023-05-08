import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1708 종이의 개수
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var p1 = 0
    var p0 = 0
    var pm1 = 0
    val paper = Array(n) { IntArray(n) }

    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            paper[it][index] = i
        }
    }

    fun dq(row: Int, col: Int, size: Int) {
        if (size == 1) {
            when (paper[row][col]) {
                -1 -> pm1++
                0 -> p0++
                1 -> p1++
            }
            return
        }
        var minus = 0
        var zero = 0
        var pos = 0

        for (i in row until row + size) {
            for (j in col until col + size) {
                when (paper[i][j]) {
                    -1 -> minus++
                    0 -> zero++
                    1 -> pos++
                }
            }
        }

        if (minus == size * size) {
            pm1++
            return
        }
        if (zero == size * size) {
            p0++
            return
        }
        if (pos == size * size) {
            p1++
            return
        }
        val divideSize = size / 3

        dq(row, col, divideSize)

        dq(row, col + divideSize, divideSize)
        dq(row, col + (divideSize * 2), divideSize)

        dq(row + divideSize, col, divideSize)
        dq(row + (divideSize * 2), col, divideSize)

        dq(row + divideSize, col + divideSize, divideSize)
        dq(row + (divideSize * 2), col + divideSize, divideSize)
        dq(row + divideSize, col + (divideSize * 2), divideSize)
        dq(row + (divideSize * 2), col + (divideSize * 2), divideSize)
    }

    dq(0, 0, n)
    println(pm1)
    println(p0)
    println(p1)
}
