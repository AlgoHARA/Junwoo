import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

/*
* 14500 테트로미노
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    var result = 0
    repeat(n) {
        readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            map[it][index] = i
        }
    }

    fun check1(row: Int, col: Int) {
        // 길쭉 / 오 오 오 / 위 위 위
        var temp = 0
        if (row + 3 < m) {
            temp = map[col][row]
            for (i in 1 until 4) {
                temp += map[col][row + i]
            }
            result = max(result, temp)
        }
        if (col + 3 < n) {
            temp = map[col][row]
            for (i in 1 until 4) {
                temp += map[col + i][row]
            }
            result = max(result, temp)
        }
    }

    fun check2(row: Int, col: Int) {
        // 네모
        if (row - 1 >= 0 && col - 1 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col][row - 1] + map[col - 1][row - 1])
        }
    }

    fun check3(row: Int, col: Int) {
        // 3 / 아 아 오 / 아 아 왼 / 위 위 왼 / 위 위 오
        // 아 왼 왼 / 아 오 오 / 위 왼 왼 / 위 오 오
        if (row - 1 >= 0 && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col - 2][row] + map[col - 2][row - 1])
        }
        if (row + 1 < m && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col - 2][row] + map[col - 2][row + 1])
        }
        if (row - 1 >= 0 && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col][row - 1] + map[col - 1][row - 1] + map[col - 2][row - 1])
        }
        if (row + 1 < m && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col][row + 1] + map[col - 1][row + 1] + map[col - 2][row + 1])
        }

        if (row + 2 < m && col + 1 < n) {
            result = max(result, map[col][row] + map[col + 1][row] + map[col + 1][row + 1] + map[col + 1][row + 2])
        }
        if (row - 2 >= 0 && col + 1 < n) {
            result = max(result, map[col][row] + map[col + 1][row] + map[col + 1][row - 1] + map[col + 1][row - 2])
        }
        if (row + 2 < m && col + 1 < n) {
            result = max(result, map[col][row] + map[col][row + 1] + map[col][row + 2] + map[col + 1][row + 2])
        }
        if (row - 2 >= 0 && col + 1 < n) {
            result = max(result, map[col][row] + map[col][row - 1] + map[col][row - 2] + map[col + 1][row - 2])
        }

    }

    fun check4(row: Int, col: Int) {
        // 4 / 아 오 아 / 아 왼 아 / 왼 위 왼 / 오 위 오
        if (row - 1 >= 0 && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col - 1][row - 1] + map[col - 2][row - 1])
        }
        if (row + 1 < m && col - 2 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col - 1][row + 1] + map[col - 2][row + 1])
        }
        if (row - 2 >= 0 && col + 1 < n) {
            result = max(result, map[col][row] + map[col][row - 1] + map[col + 1][row - 1] + map[col + 1][row - 2])
        }
        if (row + 2 < m && col + 1 < n) {
            result = max(result, map[col][row] + map[col][row + 1] + map[col + 1][row + 1] + map[col + 1][row + 2])
        }
    }

    fun check5(row: Int, col: Int) {
        // ㅗ / 위 왼 오 / 아 왼 오 / 아 위 왼 / 아 위 오
        if (row - 1 >= 0 && row + 1 < m && col + 1 < n) {
            result = max(result, map[col][row] + map[col + 1][row] + map[col][row - 1] + map[col][row + 1])
        }
        if (row - 1 >= 0 && row + 1 < m && col - 1 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col][row - 1] + map[col][row + 1])
        }
        if (col - 1 >= 0 && col + 1 < n && row - 1 >= 0) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col + 1][row] + map[col][row - 1])
        }
        if (col - 1 >= 0 && col + 1 < n && row + 1 < m) {
            result = max(result, map[col][row] + map[col - 1][row] + map[col + 1][row] + map[col][row + 1])
        }
    }

    map.forEachIndexed { col, ints ->
        ints.forEachIndexed { row, _ ->
            check1(row, col)
            check2(row, col)
            check3(row, col)
            check4(row, col)
            check5(row, col)
        }
    }

    print(result)

}
