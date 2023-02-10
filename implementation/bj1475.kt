import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine()
    val nums = MutableList(10) { 0 }
    num.map { it.code - 48 }.forEach {
        nums[it] += 1
    }
    if ((nums[9] + nums[6]) % 2 == 0) {
        nums[6] = (nums[9] + nums[6]) / 2
        nums[9] = 0
    } else {
        nums[6] = (nums[9] + nums[6]) / 2 + 1
        nums[9] = 0
    }
    print(nums.max())
}
