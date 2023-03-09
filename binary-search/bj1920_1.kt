import java.io.BufferedReader
import java.io.InputStreamReader

/*
1920 이진탐색
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }.toMutableSet() //set을 통하여 n에 대하여 중복제거
    val m = readLine().toInt()
    val search = readLine()!!.split(" ").map { it.toInt() }

    search.forEach{
        if(num.contains(it)) println(1) //contains사용해서 num에 search의 숫자가 있으면 1 출력
        else println(0)
    }
}
