import java.io.BufferedReader
import java.io.InputStreamReader

/*
* 14888 연산자 끼워넣기
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val count = readLine().toInt()
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    val nums = readLine().split(" ").map { it.toInt() }
    val oper = mutableListOf<Char>()
    val inputs = readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(count - 1)

    inputs.forEachIndexed { index, i ->
        repeat(i) {
            when (index) {
                0 -> oper.add('+')
                1 -> oper.add('-')
                2 -> oper.add('*')
                3 -> oper.add('/')
            }
        }
    }

    fun backtrack(depth: Int, num: Int) {
        if (depth == count - 1) {
            if (num > max) max = num
            if (num < min) min = num
            return
        }

        for (i in 0 until count - 1) {
            if (!visited[i]) {
                visited[i] = true
                when (oper[i]) {
                    '+' -> backtrack(depth + 1, num + nums[depth + 1])
                    '-' -> backtrack(depth + 1, num - nums[depth + 1])
                    '*' -> backtrack(depth + 1, num * nums[depth + 1])
                    '/' -> backtrack(depth + 1, num / nums[depth + 1])
                }
                visited[i] = false
            }
        }
    }

    backtrack(0, nums[0])
    println(max)
    print(min)
}
