import java.io.BufferedReader
import java.io.InputStreamReader

/*
백준 17608 막대기
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val nums = mutableListOf<Int>()
    var top = 0
    var result = 0
    repeat(readLine().toInt()){
        nums.add(readLine().toInt())
    }
    nums.reversed().forEach{
        if(top < it) {
            result += 1
            top = it
        }
    }
    print(result)
}
