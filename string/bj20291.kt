import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 20291 파일 정리
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val files = HashMap<String, Int>()
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val temp = readLine().split(".")
        if (files[temp[1]] == null) {
            files.put(temp[1], 1)
        } else {
            files[temp[1]] = files[temp[1]]!! + 1
        }
    }
    files.toList().sortedBy { (key, value) -> key }.toMap().forEach { (t, u) ->
        sb.append("$t $u\n")
    }
    print(sb)
}
