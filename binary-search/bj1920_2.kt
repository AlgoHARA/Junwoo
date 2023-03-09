import java.io.BufferedReader
import java.io.InputStreamReader

/*
1920 이진탐색
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }.sorted() // kotlin 내장 binarySearch는 Comparable list에만 작동하므로 한번 정렬해주어야 함
    val m = readLine().toInt()
    val search = readLine().split(" ").map { it.toInt() }

    search.forEach {
        if(num.binarySearch(it) < 0){ // binarySearch로 찾았을때 해당 결과가 없으면 -(n+1) = -(num의 사이즈 + 1) 를 출력하므로 음수가 나온다.
            println(0)
        }else{
            println(1)
        }
    }
}
