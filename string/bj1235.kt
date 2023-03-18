import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1235 학생 번호
*/ 

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val students = mutableListOf<String>()
    val set = mutableSetOf<String>()
    var count = 0
    var result = -1

    repeat(readLine().toInt()) {
        students.add(readLine().reversed())
    }

    val end = students[0].length
    while (count != end) {
        set.clear()
        students.forEach {
            set.add(it.substring(0, count))
        }
        if (set.size == students.size) {
            result = set.first().length
            break
        }
        count++
    }

    if (result == -1)
        print(students[0].length)
    else
        print(result)
}
