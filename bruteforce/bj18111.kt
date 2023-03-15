import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
* 18111 마인크래프트
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, b) = br.readLine().split(" ").map { it.toInt() }
    var minHeight = 256
    var maxHeight = 0
    var sum = 0L
    val arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine(), " ")
        for (j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
            sum += arr[i][j]
            minHeight = minOf(minHeight, arr[i][j])
            maxHeight = maxOf(maxHeight, arr[i][j])
        }
    }

    val averageHeight = (sum + b) / (n * m)
    maxHeight = minOf(maxHeight, averageHeight.toInt(), 256)

    var minTime = Long.MAX_VALUE
    var minTimeHeight = 0

    for (targetHeight in minHeight..maxHeight) {
        var time = 0L

        for (row in arr) {
            for (height in row) {
                time += when {
                    height > targetHeight -> 2 * (height - targetHeight).toLong()
                    height < targetHeight -> targetHeight - height.toLong()
                    else -> 0L
                }
            }
        }

        if (time <= minTime) {
            minTime = time
            minTimeHeight = targetHeight
        }
    }

    println("$minTime $minTimeHeight")
}
