import java.lang.Math.min

fun main() {

    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readLine()!!.toInt())
    }
    list.sort() // 원본 정렬
    var start = 0
    var end: Int = 0
    var cur = 0
    var result = Int.MAX_VALUE
    while (true) {
        if(end >= list.size) break // 탈출 구문 잘 만들기

        cur = list[end] - list[start]
        if (cur <= 4) {
            result = min(result, 5 - (end - start + 1)) // 해당 부분 계산 잘하기
            end++
        } else {
            start++
        }
    }

    println(result)

}
