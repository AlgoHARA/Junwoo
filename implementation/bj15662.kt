import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj15662 톱니바퀴(2)
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    val saw = Array(t) { IntArray(8) }
    var result = 0

    repeat(t) {
        readLine().map { it.code - '0'.code }.forEachIndexed { index, tooth ->
            saw[it][index] = tooth
        }
    }
    fun clockWise(num: Int, direction: Int) {
        val list = saw[num].copyOf() // 깊은복사!!
        if (direction == 1) {
            for (i in 1..7) {
                list[i] = saw[num][i - 1]
            }
            list[0] = saw[num][7]
        } else {
            for (i in 6 downTo 0) {
                list[i] = saw[num][i + 1]
            }
            list[7] = saw[num][0]
        }
        saw[num] = list
    }

    repeat(readLine().toInt()) {
        val (n, d) = readLine().split(" ").map { it.toInt() }
        var left = 0
        var flag = -1
        var right = 0

        for (i in n - 1 downTo 1) {
            if (saw[i - 1][2] != saw[i][6]) left++
            else break
        }
        for (i in n - 1 until t - 1) {
            if (saw[i][2] != saw[i + 1][6]) right++
            else break
        }
        clockWise(n - 1, d)// 기본 회전

        repeat(left) {
            clockWise(n - 2 - it, d * flag)
            flag *= -1
        }
        flag = -1
        repeat(right) {
            clockWise(n + it, d * flag)
            flag *= -1
        }
    }

    repeat(t) {
        if (saw[it][0] == 1) {
            result += 1
        }
    }

    print(result)
}
