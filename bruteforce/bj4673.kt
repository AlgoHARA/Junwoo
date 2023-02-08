import java.io.BufferedReader
import java.io.InputStreamReader

/*
4673 셀프 넘버
 */

fun main() {
    val nums = MutableList(10001) { i -> i } // 0 ~ 10000 까지 리스트의 값을 초기화

    repeat(10001) { i ->
        val selfNum = selfNum(i)
        if (selfNum <= 10000) nums[selfNum] = 0 // 생성자가 있는 수는 값을 0으로 변경
    }

    nums.forEach {
        if (it != 0) println(it)
    }

}

fun selfNum(n: Int): Int =
    n.toString().map {
        it.code - '0'.code
    }.sum() + n // 각 자리수들의 합과 자기 자신 더하는 함수
