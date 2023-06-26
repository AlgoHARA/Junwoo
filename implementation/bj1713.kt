import java.io.BufferedReader
import java.io.InputStreamReader

/*
* bj1713 후보 추천하기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val t = readLine().toInt()
    val nums = IntArray(101)
    val candidate = mutableListOf<Int>()

    val list = readLine().split(" ").map { it.toInt() }

    list.forEach { input ->
        if ((candidate.size < n) && !candidate.contains(input)) { // 포함안되어 있는 경우
            candidate.add(input)
            nums[input]++
        } else {
            if(!candidate.contains(input)){
                val min = nums.filterNot { it == 0 }.min()
                val temp = mutableListOf<Int>()
                nums.forEachIndexed { index, it ->
                    if (min == it) temp.add(index)
                }
                for (i in candidate) {
                    if (temp.contains(i)) {
                        candidate.remove(i)
                        candidate.add(input)
                        nums[i] = 0
                        break
                    }
                }
            }
            nums[input]++
        }
    }
    print(candidate.sorted().joinToString(" "))
}
