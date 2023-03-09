import java.io.BufferedReader
import java.io.InputStreamReader

/*
1920 이진탐색
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val num = readLine().split(" ").map { it.toInt() }.sorted()
    val m = readLine().toInt()
    val search = readLine().split(" ").map { it.toInt() }

    search.forEach {
        if (binarySearch(num, it) == -1)
            println(0)
        else
            println(1)
    }
}

fun binarySearch(arr: List<Int>, target: Int): Int { // 정석적인 이진탐색 함수
    var low = 0
    var high = arr.lastIndex
    var mid = 0

    while (low <= high) {
        mid = (low + high) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] > target -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return -1
}
