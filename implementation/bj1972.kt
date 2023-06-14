import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1972 놀라운 문자열
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    while (true) {
        val str = readLine()
        var flag = true
        var count = 0
        if (str == "*") break
        if (str.length == 1 || str.length == 2) {
            sb.append("$str is surprising.\n")
        } else {
            val n = str.length
            for (i in 0 .. n - 2) {
                val list = mutableSetOf<String>()
                count = 0
                for (j in 0 until n - i-1) {
                    count++
                    list.add("${str[j]}${str[j + i+1]}")
                }
                if(count != list.size) flag = false
            }
            if (flag)
                sb.append("$str is surprising.\n")
            else
                sb.append("$str is NOT surprising.\n")
        }
    }
    print(sb)
}
