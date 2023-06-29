import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

/*
* bj14891 톱니바퀴
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val saw = Array(4) { IntArray(8) }
    var result = 0

    repeat(4) {
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
        val points = listOf<Int>(saw[0][2], saw[1][6], saw[1][2], saw[2][6], saw[2][2], saw[3][6])
        when (n) {
            1 -> {
                if (points[0] == points[1]) {
                    clockWise(0, d)
                } else {
                    if (points[2] == points[3]) {
                        clockWise(0, d)
                        clockWise(1, d * -1)
                    } else {
                        if (points[4] == points[5]) {
                            clockWise(0, d)
                            clockWise(1, d * -1)
                            clockWise(2, d)
                        } else {
                            clockWise(0, d)
                            clockWise(1, d * -1)
                            clockWise(2, d)
                            clockWise(3, d * -1)
                        }
                    }
                }
            }

            2 -> {
                if (points[1] == points[0]) {
                    clockWise(1, d)
                } else {
                    clockWise(1, d)
                    clockWise(0, d * -1)
                }

                if (points[2] == points[3]) {

                } else {
                    if (points[4] == points[5]) {
                        clockWise(2, d * -1)
                    } else {
                        clockWise(2, d * -1)
                        clockWise(3, d)
                    }
                }
            }

            3 -> {
                if (points[4] == points[5]) {
                    clockWise(2, d)
                } else {
                    clockWise(2, d)
                    clockWise(3, d * -1)
                }

                if (points[2] == points[3]) {

                } else {
                    if (points[1] == points[0]) {
                        clockWise(1, d * -1)
                    } else {
                        clockWise(1, d * -1)
                        clockWise(0, d)
                    }
                }
            }

            4 -> {
                if (points[4] == points[5]) {
                    clockWise(3, d)
                } else {
                    if (points[2] == points[3]) {
                        clockWise(3, d)
                        clockWise(2, d * -1)
                    } else {
                        if (points[1] == points[0]) {
                            clockWise(3, d)
                            clockWise(2, d * -1)
                            clockWise(1, d)
                        } else {
                            clockWise(3, d)
                            clockWise(2, d * -1)
                            clockWise(1, d)
                            clockWise(0, d * -1)
                        }
                    }
                }
            }
        }
    }

    repeat(4) {
        if (saw[it][0] == 1) {
            result += 2.0.pow(it).toInt()
        }
    }

    print(result)
}
