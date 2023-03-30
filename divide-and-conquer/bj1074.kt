import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StrictMath.pow

/*
* 1074 Z 
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }
    var count = 0

    fun dc(x: Int, y: Int, size: Int) {
        val half = size / 2
        if (x == c && y == r) {
            print(count)
            return
        }
        if ((y <= r && r < y + size) && (x <= c && c < x + size)) {
            dc(x, y, half) // 1사분면
            dc(x + half, y, half) // 2사분면
            dc(x, y + half, half)// 3사분면
            dc(x + half, y + half, half)//4사분면
        } else {
            count += size * size // 범위에 없는 이전 사분면 만큼의 넓이를 더해줘서 이후 Z의 수를 구할때 사용
        }
        return
    }

    dc(0, 0, pow(2.0, n.toDouble()).toInt())
}
