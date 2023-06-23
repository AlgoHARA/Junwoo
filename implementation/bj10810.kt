import java.io.BufferedReader
import java.io.InputStreamReaer

/*
* bj10810 공 넣기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val basket = IntArray(n)
    repeat(m){
        val (i,j,k) = readLine().split(" ").map { it.toInt() }
        for (index in i..j){
            basket[index-1] = k
        }
    }
    print(basket.joinToString(" "))
}
