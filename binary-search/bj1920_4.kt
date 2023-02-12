import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
1920 이진탐색
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }.sorted()
    val m = readLine().toInt()
    val search = readLine().split(" ").map { it.toInt() }
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    search.forEach {
        if (num.binarySearch(it) < 0) 
            bw.write("0\n") //print가 아닌 BufferdWrite에 문자열을 넣어주고
        else
            bw.write("1\n")
    }
    bw.flush() // 콘솔에 저장된 문자열을 한번에 출력
    bw.close()
}
