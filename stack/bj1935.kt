import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Stack


/*
백준 1935 후위표기식2
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nums = Stack<BigDecimal>() // 문제조건의 숫자 조건에 꽤 꺼서 BidDecimal 사용
    val count = readLine().toInt()
    var sen = readLine()

    val df = DecimalFormat("#.00")

    repeat(count) {
        val temp = readLine().toInt()
        sen = sen.replace((it + 65).toChar(), (temp + 48).toChar())
        // 기존식에 있는 A B C D F 등을 1 2 3 4 5 등 입력받은 숫자로 바꾸어줌
    }

    sen.forEach {
        when (it) {
            '+' -> nums.push(nums.pop() + nums.pop())
            '*' -> nums.push(nums.pop() * nums.pop())
            '-' -> nums.push(-(nums.pop()) + nums.pop())
            '/' -> {
                val num1 = nums.pop()
                val num2 = nums.pop()
                nums.push(num2 / num1)
            } // - / 를 할때는 순서가 중요하므로 다음과 같이 pop의 역순으로 처리
            else -> nums.push(df.format(it.code - 48).toBigDecimal())
        }
    }
    print(df.format(nums.pop()))
}
