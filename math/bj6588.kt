import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/*
* bj6588 골드바흐의 추측
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val limit = 1000000
    val primeList = BooleanArray(limit + 1) { true }
    primeList[0] = false
    primeList[1] = false

    val sqrtLimit = sqrt(limit.toDouble()).toInt()
    for (i in 2..sqrtLimit) {
        if (primeList[i]) {
            for (j in i * i..limit step i) {
                primeList[j] = false
            }
        }
    }

    while (true) {
        val n = readLine().toInt()
        if (n == 0) break

        var isPossible = false
        for (i in 3..n / 2 step 2) {
            if (primeList[i] && primeList[n - i]) {
                bw.write("$n = $i + ${n - i}\n")
                isPossible = true
                break
            }
        }
        if (!isPossible) bw.write("Goldbach's conjecture is wrong.\n")
    }

    bw.flush()
    bw.close()
}

