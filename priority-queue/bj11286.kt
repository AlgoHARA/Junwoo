import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.util.*

/*
* bj11286 절대값 힙
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val pq = PriorityQueue<Pair<Int, Int>>(Comparator<Pair<Int, Int>> { o1, o2 ->
        when {
            o1.first != o2.first -> o1.first.compareTo(o2.first)
            else -> o1.second.compareTo(o2.second)
        }
    })
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val num = readLine().toInt()

        if (num == 0) {
            if (pq.isEmpty()) {
                sb.append("0\n")
            } else {
                sb.append("${pq.poll().second}\n")
            }
        } else {
            pq.add(Pair(abs(num), num))
        }
    }
    println(sb)
}

/* 시간초과버전
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.lang.StringBuilder
import java.util.Collections
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val pq = PriorityQueue<Int>()
    val sb = StringBuilder()
    val negative = PriorityQueue<Int>(Collections.reverseOrder())
    val positive = PriorityQueue<Int>()

    repeat(readLine().toInt()) {
        val num = readLine().toInt()

        if (num == 0) {
            if (pq.isEmpty()) {
                sb.append("0\n")
            } else {
                val min = pq.poll()
                if (negative.contains(min * -1) && positive.contains(min)) {
                    sb.append("${negative.poll()}\n")
                } else if (negative.contains(min * -1) && !(positive.contains(min))) {
                    sb.append("${negative.poll()}\n")
                } else if (!(negative.contains(min * -1)) && positive.contains(min)) {
                    sb.append("${positive.poll()}\n")
                }
            }
        } else {
            pq.add(abs(num))
            if (num > 0) positive.add(num)
            else negative.add(num)
        }
    }
    println(sb)
}
*/
