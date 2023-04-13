import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 1931 회의실 배정
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val room = mutableListOf<Pair<Int, Int>>()
    var count = 0

    repeat(readLine().toInt()) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        room.add(Pair(s, e))
    }

    var end = 0
    room.sortedBy { it.first }.sortedBy { it.second }.forEach {
        if(it.first >= end){
            count++
            end = it.second
        }
    }
    print(count)

}
