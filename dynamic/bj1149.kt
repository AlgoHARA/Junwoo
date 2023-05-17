import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1149 RGB거리
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val red = IntArray(n)
    val green = IntArray(n)
    val blue = IntArray(n)
    
    val dpR = IntArray(n)
    val dpG = IntArray(n)
    val dpB = IntArray(n)

    repeat(n) { index ->
        val list = readLine().split(" ").map { it.toInt() }
        red[index] = list[0]
        green[index] = list[1]
        blue[index] = list[2]
    }

    for (i in 0 until n) {
        if (i == 0) {
            dpR[i] = red[i]
            dpG[i] = green[i]
            dpB[i] = blue[i]
        } else {
            dpR[i] = dpG[i - 1].coerceAtMost(dpB[i - 1]) + red[i]
            dpG[i] = dpR[i - 1].coerceAtMost(dpB[i - 1]) + green[i]
            dpB[i] = dpG[i - 1].coerceAtMost(dpR[i - 1]) + blue[i]
        }
    }
    println(dpR[n - 1].coerceAtMost(dpG[n - 1].coerceAtMost(dpB[n - 1])))
}
