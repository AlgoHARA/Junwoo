import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
10815 숫자 카드
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val sang = readLine().split(" ").map { it.toInt() }.sorted()
    val m = readLine().toInt()
    val cards = readLine().split(" ").map { it.toInt() }

    cards.forEach {
        if (sang.binarySearch(it) < 0) //코틀린 내장 이진탐색 결과가 있으면 인덱스 없으면 음수 반환
            bw.append("0 ")
        else
            bw.append("1 ")
    }
    bw.flush()
    bw.close()
}
